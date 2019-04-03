[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)

【Github指令】
echo "# thoughtworks" >> README.md

cd 本地目录

git init

git add README.md

git commit -m "first commit"

git remote add origin https://github.com/vicotorz/thoughtworks.git

git push -u origin master


[git 错误]

error: src refspec master does not match any.

(目录中没有文件，空目录是不能提交上去的)

$ git add ...


remote origin already exists 错误解决办法

1、先删除远程 Git 仓库

$ git remote rm origin

2、再添加远程 Git 仓库

$ git remote add origin git@github.com:FBing/Java-code-generator
