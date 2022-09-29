import Admin from "./pages/Admin";
import Comment from "./pages/Comment";
import WriteBlog from "./pages/WriteBlog";
import ReadBlog from "./pages/ReadBlog";
import Art from "./pages/Art";
import Blogs from "./pages/Blogs";
import Arts from "./pages/Arts";
import Auth from "./pages/Auth";
import Main from "./pages/Main";
import CreateArt from "./pages/CreateArt";
import {
  ADMIN_ROUTE,
  WRITE_BLOG_ROUTE,
  ART_ROUTE,
  COMMENT_ROUTE,
  LOGIN_ROUTE,
  REGISTRATION_ROUTE,
  ALL_BLOG_ROUTE,
  ALL_ART_ROUTE,
  MAIN_ROUTE,
  CREATE_ART_ROUTE,
  HASH_BLOG_ROUTE,
  } from "./utils/consts";
import HashBlog from "./components/HashBlog";


export const authRouts = [
  {
    path: ADMIN_ROUTE,
    Component: Admin,
  },
  {
    path: WRITE_BLOG_ROUTE,
    Component: WriteBlog,
  },
  {
    path: ART_ROUTE,
    Component: Art,
  },
  {
    path: COMMENT_ROUTE,
    Component: Comment,
  },
  {
    path: CREATE_ART_ROUTE,
    Component: CreateArt,
  },
];

export const publicRouts = [
  {
    path: MAIN_ROUTE,
    Component: Main,
  },
  {
    path: LOGIN_ROUTE,
    Component: Auth,
  },
  {
    path: REGISTRATION_ROUTE,
    Component: Auth,
  },
  {
    path: ALL_BLOG_ROUTE,
    Component: Blogs,
  },
  {
    path: ALL_ART_ROUTE,
    Component: Arts,
  },
  {
    path: ALL_ART_ROUTE + "/:id",
    Component: Art,
  },
  {
    path: ALL_BLOG_ROUTE + "/:id",
    Component: ReadBlog,
  },
  {
    path: HASH_BLOG_ROUTE + "/:id",
    Component: HashBlog,
  },
];
