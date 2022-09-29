import _ from "lodash";
import jsonPlaceholder from "../apis/jsonPlaceholder.js";

export const fetchPostsAndUsers = () => async (dispatch, getState) => {
  await dispatch(fetchPosts());
  const userIds = _.uniq(_.map(getState().posts, "userId"))
  userIds.forEach(id=>dispatch(fetchUser(id)))


  /*SAME THING LIKE - 6 AND 7 ROWS */
  // _.chain(getState().posts)
  //   .map("userId")
  //   .uniq()
  //   .forEach(id=>dispatch(fetchUser(id)))
  //   .value();
};

export const fetchPosts = () => {
  return async (dispatch) => {
    const response = await jsonPlaceholder.get("/posts");

    dispatch({
      type: "FETCH_POSTS",
      payload: response.data,
    });
  };
};

export const fetchUser = (id) => {
  return async (dispatch) => {
    const response = await jsonPlaceholder.get(`/users/${id}`);
    dispatch({
      type: "FETCH_USER",
      payload: response.data,
    });
  };
};

// export const fetchUser = (id) => {
//   return (dispatch) => {
//     _fetchUser(id, dispatch);
//   };
// };

// const _fetchUser = _.memoize(async (id, dispatch) => {
//   const response = await jsonPlaceholder.get(`/users/${id}`);
//   dispatch({
//     type: "FETCH_USER",
//     payload: response.data,
//   });
// });
