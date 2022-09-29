import jwt_decode from "jwt-decode";
import _ from "lodash";

import { $host, $authHost } from "../api/index";
import { setUser, deleteUser, editRole } from "../redusers/userReduser";
import { setBlogs } from "../redusers/blogReduser";
import { setComment } from "../redusers/commentReduser";
import { addComment } from "../redusers/addCommentReduser";
import { addPost, deletePost, updatePost } from "../redusers/addPostReduser";
import { setArts } from "../redusers/artsReduser";
import { addArt, deletedArt, updatedArt } from "../redusers/addArtReduser";
import { setOneBlog } from "../redusers/blogCarousselReduser";
import { allAudience } from "../redusers/audienceReduser";
import { addTag, connectTag } from "../redusers/addHashTagReduser";
import { allTags } from "../redusers/getHashTagReducer";
import { setListBlogs } from "../redusers/getTaggedBlogsReduser";
import { approveComment } from "../redusers/approveCommentReduser";
import { changeLanguage } from "../redusers/languageReduser";

//**** REGISTRATION, LOGIN, CHEK (AUTHORIZATION) ****//
export const registration = async (email, password, alias) => {
  try {
    const response = await $host.post("api/user/registration", {
      email,
      password,
      alias,
    });
  } catch (error) {
    console.log(error);
  }
};

export const login = (email, password) => {
  return async (dispatch) => {
    try {
      const response = await $host.post("api/user/login", {
        email,
        password,
      });
      dispatch(setUser(response.data));
      localStorage.setItem("token", response.data.token);
      return response.data.token;
    } catch (error) {
      console.log(error);
    }
  };
};

export const check = async () => {
  const response = await $authHost.get("api/user/auth");
  localStorage.setItem("token", response.data.token);
  return jwt_decode(response.data.token);
};

//**** END OF REGISTRATION, LOGIN, CHEK (AUTHORIZATION) ****//

//**** AUDIENCE SECTION ****//

export const fetchAudience = () => {
  return async (dispatch) => {
    try {
      const response = await $authHost.get(`api/user`);
      dispatch(allAudience(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const editUserInfo = (formData) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.patch("/api/user", formData);
      dispatch(editRole(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

// {export const deleteUserAct = (id) => {
//   return async (dispatch) => {
//     try {
//       const response = await $authHost.delete(`/api/user/${id}`);
//       console.log("action delete user", response.data);
//       dispatch(deleteUser(response.data));
//     } catch (error) {
//       console.log(error);
//     }
//   };
// };}

//**** END OFAUDIENCE SECTION ****//

//***** COMMENTS SECTION *****//
export const postComment = (body, blogId, artId) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.post("/api/comment", {
        body,
        blogId,
        artId,
      });
      dispatch(addComment(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const fetchComments = (id, entity) => {
  return async (dispatch) => {
    if (entity === "blog") {
      try {
        const response = await $host.get(`api/comment/blog/${id}`);
        dispatch(setComment(response.data));
      } catch (error) {
        console.log(error);
      }
    } else {
      try {
        const response = await $host.get(`api/comment/art/${id}`);
        dispatch(setComment(response.data));
      } catch (error) {
        console.log(error);
      }
    }
  };
};

export const fetchAllComments = () => {
  return async (dispatch) => {
    try {
      const response = await $host.get(`api/comment/`);
      dispatch(setComment(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const matchingComment = (id) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.post(`api/comment/${id}`);
      dispatch(approveComment(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const deleteComment = (id) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.delete(`/api/comment/${id}`);
      dispatch(deletePost(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};
//***** END OF COMMENTS SECTION *****//

//***** BLOG SECTION *****//

export const postBlog = (formData) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.post("/api/blog", formData);
      dispatch(addPost(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const updateBlog = (formData) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.patch("/api/blog", formData);
      dispatch(updatePost(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const deleteBlog = (id) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.delete(`/api/blog/${id}`);
      dispatch(deletePost(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const fetchBlogs = () => {
  return async (dispatch) => {
    try {
      const response = await $host.get("api/blog");
      dispatch(setBlogs(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const fetchOneBlog = (id) => {
  return async (dispatch) => {
    try {
      const response = await $host.get(`api/blog/${id}`);
      dispatch(setOneBlog(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

//***** END OF BLOG SECTION *****//

//***** ART (CRAFT) SECTION *****//
export const createArt = (formData) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.post("/api/art", formData);
      dispatch(addArt(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const updateArt = (formData) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.patch("/api/art", formData);
      dispatch(updatedArt(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const deleteArt = (id) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.delete(`/api/art/${id}`);
      dispatch(deletedArt(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const fetchArts = () => {
  return async (dispatch) => {
    try {
      const response = await $host.get("api/art");
      dispatch(setArts(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

//***** END OF ART (CRAFT) SECTION *****/

//***HASHTAG SECTION ****//

export const addHashTag = (name, blogId) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.post("/api/hashtag", {
        name,
        blogId,
      });
      console.log("index actions, got this", response);
      dispatch(addTag(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const connectHashTag = (name, blogId) => {
  return async (dispatch) => {
    try {
      const response = await $authHost.post("/api/hashtag/connect", {
        name,
        blogId,
      });
      console.log("index actions connect, got this", response);
      dispatch(connectTag(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const fetchTags = () => {
  return async (dispatch) => {
    try {
      const response = await $host.get("api/hashtag");
      dispatch(allTags(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

export const fetchTaggedBlogs = (id) => {
  return async (dispatch) => {
    try {
      const response = await $host.get("api/hashtag/" + id);
      console.log(response.data);
      dispatch(setListBlogs(response.data));
    } catch (error) {
      console.log(error);
    }
  };
};

//***END OF HASHTAG SECTION ****//

//***OTHER SECTION ****//

