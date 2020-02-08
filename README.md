### 1.克隆项目(导出):

**创建ssh密匙**(生成一个新的SSH密钥用于身份验证，然后将其添加到ssh-agent中。)(免密克隆(记住密码))

1. 打开Git Bash。(在将要导出文件下**右键**)

2. 粘贴以下文本，替换为您的GitHub电子邮件地址。

   (**使用提供的电子邮件作为标签，这将创建一个新的ssh密钥。**)

   ```
   $ ssh-keygen -t rsa -b 4096 -C "yang92yxh@qq.com"
   ```

3. 提示输入保存位置,键入**Enter**:默认地址

4. 输入密码yangxihao0529

5. 将SSH私钥添加到ssh-agent。如果您使用其他名称创建密钥，或者要添加具有其他名称的现有密钥，请使用私有密钥文件的名称替换命令中的*id_rsa*。

   ```
   $ ssh-add ~/.ssh/id_rsa
   ```

6. CopySSH密匙

   ```
   $ clip < ~/.ssh/id_rsa.pub
   ```

7. 进入github个人设置中新建`SSHandGPG密匙`,输入密码

8. 在导出文件下`shirt+右键`在此处打开Powershell窗口(使用ssh克隆复制代码)

   ```
   git clone git@github.com:xih-yang/demo.git
   ```

**推向远端(上传)**

![img](https://www.runoob.com/wp-content/uploads/2015/02/1352126739_7909.jpg)

| 工作区         | 在导出地址的文件下就是工作区,有个.git的隐藏文件(表示被git接管) |
| -------------- | ------------------------------------------------------------ |
| 版本库(暂存区) | 称为`stage`或者`index`,暂时存放.git目录下的index(.git/index) |
| 版本库(master) | 工作区的                                                     |
|                |                                                              |

- [ ] ​	`cd demo\`进入工作区的demo, `git status` 查看一下 他的状态(首先新建了一个文件(xiyang))

- [ ] `git add xiyang`,添加到`index`,` git commit -m "提交注释"`

- [ ] 提示配置邮箱和用户名(告诉她你是谁)

  ```
  git config --global user.email "yang92yxh@163.com"
  git config --global user.name "xih-yang"
  ```

- [ ] 再次提交 git commit -m "注释"

- [ ] `git push` 上传

  

可以查看更新

​	git log , 复制 commit 后面的 编码 git show 编码 查看

master中的文件reset到index中

返回index修改重新提交

​	`git log` ->复制编码 -> `git reset 编码`->`git log` ->`git add .`->git status ->git commit -m "注释" ->git log

git 提交注释规则:

​		git commit -m "$(v)" v: chore : 项目搭建  feat:增加新功能 fix:改bug style:改样式 test:测试

上传push之后可能回报错,别人修改了文件 

​		`git pull` 更新代码,更改之后重复之前步骤

创建分支

​		git branch testBranch 创建

​		git checkout testBranch 进入

​		git status 查看 (已经在这个分支中)

​		创建java文件push ,  `git push --set-upstream origin testBranch`,在远程 添加分支并 添加

​		`git checkout -b testBranch2` 检出并创建新的分支

总合并

​		回到 master  , `git checkout master` , 回来之后 git pull  获取最新代码,git merge branch1(test分支)


                             git 命令
git init    #初始一个不是git的项目,变成git项目

配置用户名和邮箱
                            vim编辑
按ESC键 跳到命令模式，然后：

:w - 保存文件，不退出 vim
:w file -将修改另外保存到 file 中，不退出 vim
:w! -强制保存，不退出 vim
:wq -保存文件，退出 vim
:wq! -强制保存文件，退出 vim
:q -不保存文件，退出 vim
:q! -不保存文件，强制退出 vim
:e! -放弃所有修改，从上次保存文件开始再编辑

h2 登录问题
h2-user
    在database 中h2数据库 右键打开控制台 console
    
       create user sa password  '123';--创建用户
       alter user sa admin true;--修改权限
       alter user SA set password '123'--修改用户密码

mysql url 8.19
url=jdbc:mysql://localhost:3306/youdatabasename?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC



##脚本
``` h2 sql
create table USER
(
	ID INT auto_increment,
	NAME VARCHAR(255),
	ACCOUNT_ID VARCHAR(255),
	TOKEN VARCHAR(255),
	GMT_CREATE LONG,
	GMT_MODIFIED LONG
);


```