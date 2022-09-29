import { combineReducers } from "redux";

import userReduser from "./userReduser";
import blogReduser from "./blogReduser";
import commentReduser from "./commentReduser";
import addCommentReduser from "./addCommentReduser";
import artsReduser from "./artsReduser";
import audienceReduser from "./audienceReduser";
import addHashTagReduser from "./addHashTagReduser";
import getHashTagReducer from "./getHashTagReducer";
import getTaggedBlogsReduser from "./getTaggedBlogsReduser";
import languageReduser from "./languageReduser";


export default combineReducers({
  user: userReduser,
  userRole: userReduser,
  blogs: blogReduser,
  comments: commentReduser,
  comment: addCommentReduser,
  arts:artsReduser,
  audience: audienceReduser,
  hashTag: addHashTagReduser,
  tags:getHashTagReducer,
  taggedBlogs: getTaggedBlogsReduser,
  language: languageReduser
});
