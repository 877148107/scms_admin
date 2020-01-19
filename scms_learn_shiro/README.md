## **scms_learn_shiro**

------

## 1.Apache  Shiro简介

[shiro官网]: http://shiro.apache.org

Apache Shiro是一个功能强大且灵活的开源安全框架，可以干净地处理身份验证，授权，企业会话管理和加密。

Apache Shiro的首要目标是易于使用和理解。安全有时可能非常复杂，甚至会很痛苦，但这不是必须的。框架应尽可能掩盖复杂性，并公开简洁直观的API，以简化开发人员确保其应用程序安全的工作。

您可以使用Apache Shiro进行以下操作：

- 验证用户身份以验证其身份
- 对用户执行访问控制，例如：
  - 确定是否为用户分配了特定的安全角色
  - 确定是否允许用户做某事
- 即使在没有Web或EJB容器的情况下，也可以在任何环境中使用Session API。
- 在身份验证，访问控制或会话的生存期内对事件做出反应。
- 汇总1个或更多用户安全数据的数据源，并将其全部显示为单个复合用户“视图”。
- 启用单点登录（SSO）功能
- 启用“记住我”服务以进行用户关联，而无需登录
  … 
  等等-所有这些都集成到一个易于使用的统一API中。

Shiro尝试在所有应用程序环境中实现这些目标-从最简单的命令行应用程序到最大的企业应用程序，而不必强加对其他第三方框架，容器或应用程序服务器的依赖。当然，该项目旨在尽可能地集成到这些环境中，但是可以在任何环境中直接使用它。

## 2.Apache Shiro功能

Apache Shiro是具有许多功能的全面的应用程序安全框架。下图显示了Shiro集中精力的地方，本参考手册的组织方式也类似：

![img](http://shiro.apache.org/assets/images/ShiroFeatures.png)

Shiro以Shiro开发团队所谓的“应用程序安全性的四个基石”为目标-身份验证，授权，会话管理和密码学：

- **身份验证**(Authentication)**：**有时称为“登录”，这是证明用户是他们所说的身份的行为。
- **授权**(Authorization)**：**访问控制的过程，即确定“谁”有权访问“什么”。
- **会话管理(**Session Management**)：**即使在非Web或EJB应用程序中，也可以管理用户特定的会话。
- **密码(**Cryptography**)：**使用密码算法保持数据安全，同时仍然易于使用。

在不同的应用程序环境中，还具有其他功能来支持和加强这些问题，尤其是：

- Web支持：Shiro的Web支持API可帮助轻松保护Web应用程序。
- 缓存：缓存是Apache Shiro API的第一层公民，可确保安全操作保持快速有效。
- 并发性：Apache Shiro的并发功能支持多线程应用程序。
- 测试：测试支持可以帮助您编写单元测试和集成测试，并确保您的代码将按预期进行保护。
- “运行方式”：一种功能，允许用户采用其他用户的身份（如果允许），有时在管理方案中很有用。
- “记住我”：在整个会话中记住用户的身份，因此他们只需要在必要时登录。

## 3. Apache Shiro架构

​	Apache Shiro的设计目标是通过直观且易于使用来简化应用程序安全性。Shiro的核心设计模拟了大多数人如何在与某人（或某物）进行交互的情况下如何考虑应用程序安全性。

### 	3.1 高级概述

​		在概念层次，shiro的设计有3个主要的概念：`Subject`，`SecurityManager`和`Realms`。下图是这些组件如何交互的高级概述，我们将在下面介绍每个概念：

![img](http://shiro.apache.org/assets/images/ShiroBasicArchitecture.png)

- **Subject**：正如我们在刚才提到[教程](http://shiro.apache.org/tutorial.html)，在`Subject`本质上是当前正在执行的用户的安全特定“视图”。“用户”一词通常表示一个人，一个人`Subject`可以是一个人，但它也可以表示第三方服务，守护程序帐户，cron作业或类似的东西-基本上是当前与该软件交互的任何东西。

  `Subject`实例都绑定到（并要求）`SecurityManager`。当您与互动时`Subject`，这些互动会转化为与主题相关的互动`SecurityManager`。

- **SecurityManager**：`SecurityManager`是Shiro体系结构的核心，并充当一种“伞”对象，该对象协调其内部安全组件，这些安全组件一起形成对象图。但是，一旦为应用程序配置了SecurityManager及其内部对象图，通常就不理会它，并且应用程序开发人员几乎所有时间都花在`Subject`API上。

  稍后我们将`SecurityManager`详细讨论，但是重要的是要认识到，当您与进行交互时`Subject`，`SecurityManager`对于任何`Subject`安全操作而言，确实是幕后工作。这反映在上面的基本流程图中。

- **Realms**：Realms充当Shiro与应用程序的安全数据之间的“桥梁”或“连接器”。当真正需要与安全性相关的数据（例如用户帐户）进行交互以执行身份验证（登录）和授权（访问控制）时，Shiro会从一个或多个为应用程序配置的领域中查找许多此类内容。

  从这个意义上说，领域本质上是特定于安全性的[DAO](https://en.wikipedia.org/wiki/Data_access_object)：它封装了数据源的连接详细信息，并根据需要使关联数据可用于Shiro。在配置Shiro时，您必须至少指定一个领域用于身份验证和/或授权。所述`SecurityManager`可与多个境界被配置，但至少有一个是必需的。

  Shiro提供了开箱即用的领域，可以连接到许多安全数据源（又名目录），例如LDAP，关系数据库（JDBC），文本配置源（例如INI和属性文件）等。如果默认的Realms不能满足您的需求，那么您可以插入自己的Realm实现以表示自定义数据源。

  像其他内部组件一样，Shiro `SecurityManager`管理着如何使用领域来获取要表示为`Subject`实例的安全性和身份数据。

### 3.2 详细架构

​	下图显示了Shiro的核心架构概念，并简要概述了每个架构：

![img](http://shiro.apache.org/assets/images/ShiroArchitecture.png)

- **主题**（[`org.apache.shiro.subject.Subject`](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/subject/Subject.html)）
  当前与软件交互的实体（用户，第三方服务，计划任务等）的特定于安全性的“视图”。
- **SecurityManager**（[org.apache.shiro.mgt.SecurityManager](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/mgt/SecurityManager.html)）
  如上所述，这`SecurityManager`是Shiro体系结构的核心。它主要是一个“伞”对象，用于协调其托管组件以确保它们能够顺利协同工作。它还管理Shiro对每个应用程序用户的视图，因此它知道如何对每个用户执行安全性操作。
- **认证器**（[org.apache.shiro.authc.Authenticator](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/authc/Authenticator.html)）
  的`Authenticator`是，负责执行和用户反应，以验证（登录）的尝试的组件。当用户尝试登录时，该逻辑由执行`Authenticator`。该`Authenticator`知道如何与一个或多个协调`Realms`该商店相关的用户/帐户信息。从这些数据中获得的数据`Realms`用于验证用户的身份，以确保用户确实是他们所说的真实身份。
  - **身份验证策略**（[org.apache.shiro.authc.pam.AuthenticationStrategy](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/authc/pam/AuthenticationStrategy.html)）
    如果`Realm`配置了多个**身份验证策略**，则`AuthenticationStrategy`它将协调领域以确定确定尝试成功或失败的条件（例如，如果一个领域成功但其他领域失败） ，尝试是否成功？所有领域都必须成功吗？只有第一个？）。
- **认证器**（[org.apache.shiro.authz.Authorizer](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/authz/Authorizer.html)）
  的`Authorizer`是部件负责确定用户在该应用程序的访问控制。它是最终表明是否允许用户做某事的机制。像一样`Authenticator`，`Authorizer`还知道如何与多个后端数据源进行协调以访问角色和权限信息。在`Authorizer`使用该信息来准确确定是否允许用户执行特定的操作。
- **SessionManager**（[org.apache.shiro.session.mgt.SessionManager](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/session/mgt/SessionManager.html)）
  将`SessionManager`知道如何创建和管理用户`Session`生命周期，提供在所有环境中的用户强大的会话体验。这是安全框架领域中的一项独特功能-Shiro能够在任何环境中本地管理用户会话，即使没有Web / Servlet或EJB容器也可以。默认情况下，Shiro将使用现有的会话机制（例如Servlet容器）（如果可用），但是如果没有这种机制（例如在独立应用程序或非Web环境中），它将使用其内置的企业会话管理来提供相同的编程经验。的`SessionDAO`存在允许任何数据源被用来坚持的会议。
  - **SessionDAO**（[org.apache.shiro.session.mgt.eis.SessionDAO](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/session/mgt/eis/SessionDAO.html)）
    的`SessionDAO`执行`Session`持久代（CRUD）操作`SessionManager`。这允许将任何数据存储插入会话管理基础结构。
- **CacheManager的**（[org.apache.shiro.cache.CacheManager](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/cache/CacheManager.html)）
  的`CacheManager`创建和管理`Cache`其他四郎组件使用实例的生命周期。因为Shiro可以访问许多后端数据源以进行身份​​验证，授权和会话管理，所以缓存一直是框架中的一流架构功能，可以在使用这些数据源时提高性能。可以将任何现代的开源和/或企业缓存产品插入Shiro，以提供快速有效的用户体验。
- **算法**（[org.apache.shiro.crypto。*](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/crypto/package-summary.html)）
  密码术是企业安全框架的自然补充。Shiro的`crypto`软件包包含易于使用和理解的密码学密码，哈希（又名摘要）和不同编解码器实现的表示形式。该软件包中的所有类都经过精心设计，以使其易于使用和理解。使用Java的本机加密技术支持的任何人都知道，驯服它可能是具有挑战性的动物。Shiro的加密API简化了复杂的Java机制，并使加密技术易于普通凡人使用。
- **领域**（[org.apache.shiro.realm.Realm](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/realm/Realm.html)）
  如上所述，领域充当Shiro与应用程序的安全数据之间的“桥梁”或“连接器”。当真正需要与安全性相关的数据（例如用户帐户）进行交互以执行身份验证（登录）和授权（访问控制）时，Shiro会从一个或多个为应用程序配置的领域中查找许多此类内容。您可以根据`Realms`需要配置任意数量（通常每个数据源一个），并且Shiro会根据需要进行协调，以进行身份​​验证和授权。

### 3.3 **SecurityManager**

​	应用程序`SecurityManager`执行安全操作并管理*所有*应用程序用户的状态。在Shiro的默认`SecurityManager`实现中，这包括：

- 认证方式
- 授权书
- 会话管理
- 缓存管理
- [领域](http://shiro.apache.org/realm.html)协调
- 事件传播
- “记住我”服务
- 主题创作
- 注销等。

为了简化配置并实现灵活的配置/可插拔性，Shiro的实现在设计上都是高度模块化的-实际上是模块化的，因此SecurityManager实现（及其类层次结构）根本不起作用。相反，这些`SecurityManager`实现大多充当轻量级的“容器”组件，几乎将所有行为委派给嵌套/包装的组件。这种“包装”设计反映在上面的详细架构图中。

当组件实际执行逻辑时，`SecurityManager`实现知道如何以及何时协调组件以实现正确的行为。

## 4.[Apache Shiro术语](http://shiro.apache.org/terminology.html#apache-shiro-terminology)

- **身份**（**Authentication**）
  验证**身份**验证是验证主体身份的过程-本质上证明某人确实是他们所说的真实身份。身份验证尝试成功后，应用程序可以相信可以保证主题是应用程序期望的对象。

- **授权**（**Authorization**）
  授权（也称为访问控制）是确定是否允许用户/主题做某事的过程。通常，通过检查和解释主题的角色和权限（请参见下文），然后允许或拒绝对请求的资源或功能的访问来完成此操作。

- **密码**（**Cipher**）

  密码是一种用于执行加密或解密的算法。该算法通常依赖于一条称为密钥的信息。而且加密因密钥而异，因此如果没有密钥，解密将非常困难。

  密码有不同的变化。块密码器处理通常具有固定大小的符号块，而流密码器处理连续的符号流。对称密码使用相同的密钥进行加密和解密，而非对称密码使用不同的密钥。而且，如果不能从另一个密钥中获得非对称密码的密钥，则可以公开共享一个密钥，从而创建公用/专用密钥对。

- **凭证**（**Credential**）

  凭证是一块用于验证用户/主题的身份的信息。在身份验证尝试期间，将一个（或多个）凭据与主体一起提交，以验证提交凭据的用户/主题实际上是关联的用户。凭证通常是只有特定用户/主体才能知道的非常机密的事物，例如密码或PGP密钥或生物特征或类似机制。

  这个想法是，对于一个校长，只有一个人会知道与该校长“配对”的正确凭证。如果当前用户/主题提供的正确凭据与系统中存储的凭据相匹配，则系统可以假定并相信当前用户/主题确实是他们所说的真实身份。信任程度随着安全的凭证类型（例如，生物特征签名>密码）的增加而增加。

- **密码算法**（**Cryptography**）
  密码术是一种通过隐藏信息或将其转换为无用信息来保护信息免受不希望的访问的做法，因此其他人都无法阅读。Shiro着重研究密码学的两个核心要素：使用公钥或私钥对诸如电子邮件之类的数据进行加密的密码，以及对密码之类的数据进行不可逆地加密的哈希（即消息摘要）。

- **哈希**（**Hash**）
  函数是将输入源（有时称为消息）单向，不可逆地转换为编码的哈希值（有时称为消息摘要）的不可逆转换。它通常用于密码，数字指纹或具有基础字节数组的数据。

- **权限**（**Permission**）

  至少按照Shiro的解释，权限是一种描述应用程序中原始功能的语句，仅此而已。权限是安全策略中最低级别的构造。它们仅定义应用程序可以执行的“操作”。他们没有描述“谁”能够执行这些动作。许可只是行为的陈述，仅此而已。

  权限的一些示例：

  - 开启档案
  - 查看“ /用户/列表”网页
  - 列印文件
  - 删除“ jsmith”用户

- **Principal**

  **Principal**是一个应用程序的用户（对象）的任何识别属性。“识别属性”可以是任何对您的应用有意义的东西-用户名，姓氏，给定名称，社会保险号，用户ID等。仅此而已-没什么疯狂的。

  Shiro还引用了我们称为“ `主体` ”的*主要*负责人的内容。甲*初级*主要是唯一标识的任何主要`主题`在整个应用程序。理想的主要主体是诸如用户名或用户ID之类的东西，后者是RDBMS用户表的主键。应用程序中的用户（主题）只有一个主要主体。

- **Realm**

  领域是可以访问特定于应用程序的安全性数据（例如用户，角色和权限）的组件。可以将其视为特定于安全性的DAO（数据访问对象）。Realm将此特定于应用程序的数据转换为Shiro可以理解的格式，因此Shiro可以反过来提供单个易于理解的Subject编程API，无论存在多少数据源或您的数据有多少特定于应用程序。

  领域通常与数据源（例如关系数据库，LDAP目录，文件系统或其他类似资源）具有一对一的关联。这样，Realm接口的实现使用特定于数据源的API来发现授权数据（角色，权限等），例如JDBC，文件IO，Hibernate或JPA或任何其他数据访问API。

- **Role**

  **Role**的定义可能会根据您与谁交谈而有所不同。在许多应用程序中，人们充其量只能用一个模糊的概念来隐式定义安全策略。Shiro倾向于将角色解释为简单的命名权限集合。就这样-聚合一个或多个权限声明的应用程序唯一名称。

  这比许多应用程序使用的隐式定义更为具体。如果选择让数据模型反映Shiro的假设，则会发现您在控制安全策略方面将拥有更大的权力。

- **Session**

  会话是与单个用户/主题相关联的有状态数据上下文，该用户/主题在一段时间内与软件系统进行交互。可以在会话中添加/读取/删除数据，而受试者使用该应用程序，并且该应用程序以后可以在必要时使用此数据。当用户/主题退出应用程序或由于不活动而超时时，会话将终止。

  对于熟悉HttpSession的人来说，Shiro `会话`具有相同的目的，除了Shiro会话可以在任何环境中使用，即使没有Servlet容器或EJB容器也可以使用。

- **Subject**
  一个*主题*就是看中安全术语，基本上意味着应用程序的用户的安全，具体的“视图”。主题并不一定总是反映一个人-它可以代表调用您的应用程序的外部进程，也可以代表在一段时间内间歇执行某项任务的守护程序系统帐户（例如cron作业）。它基本上是任何正在对应用程序执行操作的实体的表示。

## 5.SpringBoot集成Shiro

### 	5.1 引入maven依赖

​	