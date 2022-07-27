/* 페이지 처리를 send를 써서 요청하는건 비효율적이다. */
const express = require("express");

const app = express();

app.use("/public", express.static(__dirname + "/public"));

//app.use('views','views');
app.set("view engine", "ejs");

app.get("/hello/:nameParam", (req, res) => {
  //파람으로 넘길때는 반드시 name.param
  res.render("hello", { name: req.params.nameParam });
});

app.listen(3000);
