# PackChannelDemo（多渠道打包）
**项目说明：productFlavors实现Android项目多渠道打包。**


## 目录结构 

- [1、productFlavors用法](#1.0.0)
- [2、productFlavors的应用场景](#2.0.0)
    - [2.1、不同包名的产品](#2.1.0)
    - [2.2、不同渠道包的产品](#2.2.0)
    - [2.3、不同依赖库的产品](#2.3.0)
    - [2.4、不同代码和资源的产品](#2.4.0)
- [3、assemble命令实现多渠道打包](#3.0.0)
    - [3.1、assemble命令](#3.1.0)
    - [3.2、图形操作实现多渠道打包](#3.2.0)
- [4、参考资料](#4.0.0)


<h2 id="1.0.0">1、productFlavors用法</h2>

`productFlavors` 顾名思义，就是`用来分别定义产品不同的特性`，使用它可以用一套代码创建不同的产品，就是用于定义`产品的特性`，这是每个产品不同的地方。有了它我们可以用同一套代码创建不同的产品。

---


<h2 id="2.0.0">2、productFlavors的应用场景</h2>

<h3 id="2.1.0">2.1、不同包名的产品</h3>

通过为产品设置不同的`applicationId`就可以编译出不同包名的APK


<h3 id="2.2.0">2.2、不同渠道包的产品</h3>

由于国内引用市场较多，因此需要为不同市场打包相应的包，通常这种包就叫做`渠道包`，我们可以使用`productFlavors`配合`manifestPlaceholders`属性的方法来替换渠道值，一般用渠道的统计无非是用友盟或者其它之类的。


<h3 id="2.3.0">2.3、不同依赖库的产品</h3>

`productFlavors`还支持自定义依赖，产品A只编译自己需要的依赖库，不需要编译对自己无用的依赖库

```
这里使用productFlavors里定义的产品名+Compile关键字来替代compile关键字。
```


<h3 id="2.4.0">2.4、不同代码和资源的产品</h3>

gradle中有一个`source set`概念，不同产品可以设置不同的`source set`，通常src/main目录是ide自动帮我们创建的文件夹，因此我们可以在src目录下创建productA/productB这样的目录，目录名需要和productFlavors中定义的产品名对应。

这样src/productA/java文件内可以放不同的代码，src/productA/res文件夹内可以放不同的资源文件，同时也可以定义不同的AndroidManifest文件，比如申请不同的权限之类。

---


<h2 id="3.0.0">3、assemble命令实现多渠道打包</h2>

<h3 id="3.1.0">3.1、assemble命令</h3>

<h3 id="3.2.0">3.2、图形操作实现多渠道打包</h3>

---


<h2 id="4.0.0">4、参考资料</h2>

- [Gradle打包APK的一些小技巧和productFlavor配置](https://my.oschina.net/sfshine/blog/725365)
- [productFlavors的简单分析（一）](http://www.jianshu.com/p/9e646683fb40)
- [使用gradle的productFlavors实现Android项目多渠道打包](http://blog.csdn.net/lj402159806/article/details/54947658)
- [AndroidStudio下BuildTypes和ProductFlavors动态编译并重命名apk](http://blog.csdn.net/angusing/article/details/47721765)
- [［Android Studio 权威教程］多渠道打包和一键完成（全部产品）打包并签名](http://blog.csdn.net/yy1300326388/article/details/48296221)

---


# License

```
 Copyright (c) 2017, The Jeterlee authors 

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
