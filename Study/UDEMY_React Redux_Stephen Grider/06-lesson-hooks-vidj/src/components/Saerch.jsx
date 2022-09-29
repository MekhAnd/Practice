import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";

const Search = () => {
  const [term, setTerm] = useState("Design");
  const [results, setResult] = useState([]);

  useEffect(() => {
    const search = async () => {
      const { data } = await axios.get("https://en.wikipedia.org/w/api.php", {
        params: {
          action: "query",
          list: "search",
          origin: "*",
          format: "json",
          srsearch: term,
        },
      });
      setResult(data.query.search);
    };

    if (term && !results.length) {
      search();
    } else {
      const timoutID = setTimeout(() => {
        if (term) {
          search();
        }
      }, 500);

      return () => {
        clearTimeout(timoutID);
      };
    }
  }, [term]);

  const renderedResult = results.map((result) => {
    return (
      <div key={result.pageid} className="item">
        <div className="right floated content">
          <a
            className="ui button"
            href={`https://en.wikipedia.org?curid=${result.pageid}`}
          >
            Go
          </a>
        </div>
        <div className="content">
          <div className="header">{result.title}</div>
          <span dangerouslySetInnerHTML={{ __html: result.snippet }}></span>
        </div>
      </div>
    );
  });

  return (
    <div className="ui container">
      <div className="ui form">
        <div className="field">
          <label htmlFor="text">Enter Search Term</label>
          <input
            type="text"
            name="text"
            className="input"
            value={term}
            onChange={(e) => setTerm(e.target.value)}
          />
        </div>
      </div>
      <div className="ui celled list">{renderedResult}</div>
    </div>
  );
};

export default Search;
