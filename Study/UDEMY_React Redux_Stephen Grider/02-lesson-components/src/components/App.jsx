import React from "react";
import { ReactDOM } from "react";
import ApprovalCard from "./ApprovalCard";
import CommentDetail from "./CommentDetail";
import faker from "faker";
import "../App.css"

const App = (props) => {
  // const cd = <CommentDetail/>
  return (
    <div className="ui container comments">
      <ApprovalCard
        childComponent={
          <CommentDetail
            author="Sam"
            time="Today at 11:00"
            text="Nice!"
            avatar={faker.image.image()}
          />
        }
      />
      <ApprovalCard
        childComponent={
          <CommentDetail
            author="Vic "
            time="Today at 10:30"
            text="mmmmmm"
            avatar={faker.image.image()}
          />
        }
      />
      <ApprovalCard
        childComponent={
          <CommentDetail
            author="Nat"
            time="Today at 09:00"
            text="Good to see!"
            avatar={faker.image.image()}
          />
        }
      />
      <ApprovalCard
        childComponent={
          <CommentDetail
            author="Jan"
            time="Today at 07:00"
            text="Ouch!"
            avatar={faker.image.image()}
          />
        }
      />
      <ApprovalCard
        childComponent={
          <CommentDetail
            author="Olg"
            time="Yesterday at 20:00"
            text="Cool!"
            avatar={faker.image.image()}
          />
        }
      />
    </div>
  );
};

export default App;
