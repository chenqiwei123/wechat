# 微信公众号开发-固定资产投资监管平台 

## 系统概述  

用户管理模块的具体功能主要包括用户（项目法人、行业主管部门人员、发改部门人员）信息的查询、修改、删除功能。其中项目法人可以注册自己的账号、项目申请、项目调度和个人信息反馈查询。行业主管部门进行整理提交项目法人提交项目信息。发改部门可以对项目法人申请的项目进行审批和项目调度的审批。并且可以查看自己的项目审批评分和整合项目数据的可视化分析。项目数据保存在数据库，可以动态展示项目的信息情况。
### 界面关系图或工作流图
![工作关系图](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/00.png?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqC3QsrVsGWgTToVcVW7fMCDH67WbvxUb%26q-sign-time%3D1589897334%3B1589900994%26q-key-time%3D1589897334%3B1589900994%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Db2595cf032452d957869ffc7a6801d4e6e79b738&x-cos-security-token=f7abd1df8cd3c4bf6e6751680fcf0252fb81cef010001)
 
## 系统模块  

### 聊天界面:
**智能获取天气api**
![首页展示](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%286%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqC3QsrVsGWgTToVcVW7fMCDH67WbvxUb%26q-sign-time%3D1589897334%3B1589900994%26q-key-time%3D1589897334%3B1589900994%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D309b9ae234ef4991cc49ce0db00a0a6421007520&x-cos-security-token=f7abd1df8cd3c4bf6e6751680fcf0252fb81cef010001)  
**语音聊天api**
![首页展示](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%284%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqC3QsrVsGWgTToVcVW7fMCDH67WbvxUb%26q-sign-time%3D1589897334%3B1589900994%26q-key-time%3D1589897334%3B1589900994%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D72c1b28d1ea55bbb5f77b73654dfc067d90643e4&x-cos-security-token=f7abd1df8cd3c4bf6e6751680fcf0252fb81cef010001) 
**图片链接**
![首页展示](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%285%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqC3QsrVsGWgTToVcVW7fMCDH67WbvxUb%26q-sign-time%3D1589897334%3B1589900994%26q-key-time%3D1589897334%3B1589900994%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D73b2cd907d9d6b55ab6c5663bf04e6530f04b3b2&x-cos-security-token=f7abd1df8cd3c4bf6e6751680fcf0252fb81cef010001) 
**消息动态**
![首页展示](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%283%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqC3QsrVsGWgTToVcVW7fMCDH67WbvxUb%26q-sign-time%3D1589897334%3B1589900994%26q-key-time%3D1589897334%3B1589900994%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Dc369d2e905da0729976e5e870af775fcd9798590&x-cos-security-token=f7abd1df8cd3c4bf6e6751680fcf0252fb81cef010001)  
**登录链接**
![首页展示](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%282%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqC3QsrVsGWgTToVcVW7fMCDH67WbvxUb%26q-sign-time%3D1589897334%3B1589900994%26q-key-time%3D1589897334%3B1589900994%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D96441c2588856070327421d73c93369a709fc5d2&x-cos-security-token=f7abd1df8cd3c4bf6e6751680fcf0252fb81cef010001)  

##  主界面  

### 楼宇管理员管理  

**固定资产投资监管微信平台系统首页，项目法人通过登录进入首页，展示出来首页相关的功能**  

![主页面](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/000.png?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D59c7bea7a64300f73d452d34a08db414c7365044&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 用户个人信息展示页面  

**用户个人信息展示界面，在允许的微信公众号获取用户信息的条例的前提下。根据OPENID获取数据库存储的用户个人信息中心页面** 

![个人中心](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%287%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Dfc09be502d927b89c6617a332dc580506f723b66&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 项目法人首页
**项目法人拥有的功能有项目申请、项目申请情况和统计展示。在项目
法人的首页有进行客服咨询的接口。项目法人的功能操作的界面**  

![项目法人首页](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%288%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D8f8dccc5a3bcc076f95caa591e9cda0da14e43a6&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 项目法人的项目申请页面  

**(3)项目法人的项目申请页面，项目法人需要填写申请的项目信息，项目申请的信息字
段经过正则表达式的校验。项目法人的填写项目基本信息页面
**  

![项目法人的项目申请页面](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2810%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D9b3245c8995fa3386803c3f5eb526044662b0b8f&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 项目申请信息页面  

**项目法人申请后的项目信息和项目审核的结果将在这个项目信息查看页面展示
项目申请信息页面
**  

![项目申请信息页面](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2811%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Ddec44f855fb40b08954ae3c4cd220bc09ccb6f1a&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 用户的信息通知模块  

**(5)用户通过登录后，系统将信息通知模块展示给用户，未读的信息将用红色标记给用
户展示出来通知页面。用户的信息通知模块展示
**  

![用户的信息通知模块](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2819%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Dfb7686e5662da5756a65a21b327a7c7a1efe7e77&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001) 

## 微信公众号信息通知  

**用户在微信平台进行相关的操作后，将以微信平台信息通知对方，项目法人申请项
目成功后，将这个消息用微信公众号的信息通知方式给用户展示和提示。项目申请通过审核也用微信的后台通知对方。微信公众号信息通知
**  

![微信公众号信息通知](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%281%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D346b72e2f0c4793150e7fd6d1f2f7725132f8148&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 项目可视化展示


**用户可以对总体项目信息查看。项目可视化展示**  

![项目可视化展示](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2812%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Dafb714bb7893a10a5aff90b156b637c86cc82a8d&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

![项目可视化展示](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2813%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3De3e682f0c59fdbf30c2184388dbce458b712e5b0&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

### 反馈页面 

**用户可以对在使用微信平台上出现的问题进行反馈。项目法人对项目申请结果出现
的不满意项目问题反馈页面**  

![反馈页面](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2814%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Dda0f659cfcec0862d11ed72bc6a8822319437707&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 联系客服的功能页面  
**联系客服的功能页面**

![联系客服的功能页面](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2815%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Dbf823419811848c06d8bbb43c23ca9b390edf263&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

![联系客服的功能页面](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2816%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3D397ce68c6a58e9e0ca8e64d3bc62fd127cbf92dc&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  

## 发改部门人员项目审核页面

**(10)发改部门人员对项目类型进行审核，发改部门人员审核的项目类型单一。不同项目
类型分发给不同的发改部门进行审核**  

![发改部门人员项目审核页面](http://cqw-images-1258738420.cos.ap-shanghai.myqcloud.com/%20%20%2820%29.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDqApNrG6Cb2pFR1iPHcmH3mZC3Tf7aMKs%26q-sign-time%3D1589897902%3B1589901562%26q-key-time%3D1589897902%3B1589901562%26q-header-list%3Dhost%26q-url-param-list%3D%26q-signature%3Dbcca95cfd44a7bd08045f6ba439e9559c0fc8136&x-cos-security-token=12aa06cc20b67a0bd334446c7eae20a82296f48b10001)  


# 项目问题和说明-公众号联系我【公众号里面回复：联系】
![wecaht](https://img2018.cnblogs.com/blog/1469234/201907/1469234-20190704102300702-2014870621.jpg)
