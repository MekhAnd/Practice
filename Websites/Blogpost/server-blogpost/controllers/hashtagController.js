const { Hashtag, Blog } = require("../models/models");
const ApiError = require("../error/ApiError");

class HashTagController {
  async createTag(req, res) {
    const { name, blogId } = req.body;
    const [hashTag, created] = await Hashtag.findOrCreate({
      where: { name: name },
      defaults: {
        name: name,
      },
    });
    if (created) {
      return res.json(hashTag);
    } else {
      console.log("Error");
    }
  }

  async connectTag(req, res) {
    const { name, blogId } = req.body;
    console.log(name, blogId);

    const hashTag = await setTimeout(() => {
      Hashtag.findOne({ where: { name: name } }).then((hashTag) => {
        console.log(hashTag);
        try {
          Blog.findOne({ where: { id: blogId } }).then((blog) => {
            hashTag.addBlog(blog, { through: { blogid: blogId } });
          });
          console.log("exists", hashTag);
          return hashTag;
        } catch (error) {
          console.log("Something went wrong", error);
        }
      });
    }, 1000);
    return res.json("Seccessfully");
  }

  

  async getAll(req, res) {
    const hashTags = await Hashtag.findAll();
    return res.json(hashTags);
  }

  async getTagged(req, res) {
    const id = req.params.id
    console.log(id)

    await Hashtag.findOne({where:{id:id}})
      .then (hashTag=>{
        console.log(hashTag.dataValues.id, " ", hashTag.dataValues.name) 
        if(!hashTag){
          console.log("this HT is not actual")
        } else {
          hashTag.getBlogs()
             .then(blogs=>{

              console.log("**************** 57",blogs)
              return res.json(blogs);
            })
          }
      })
    
    
    
  }


  async delete(req, res) {}
}

module.exports = new HashTagController();
