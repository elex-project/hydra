# Project Hydra
Simple HTML Fragment Builder

```kotlin
repositories {
    maven {
		url = uri("https://maven.pkg.github.com/elex-project/hydra")
	}
}
dependencies {
    implementation("com.elex-project:html-fragment:1.1.0")
}
```



```
IElement
     -> TextNode
     -> AbsElement
        -> IAttributable as S
        -> IChildAppendable as E
```


```java
E e = new E("p"); // or E.p()
e.id("my-elem")
        .clazz("card card-red card-primary")
        .clazz("card-1-dp")
.attr("data-elem", "true");

e.append("Hello, ");
e.style("background", "#fff")
.style("color", "transparent");
e.append(new E("span").append("World")).append(".");
e.prepend("??");

String out = e.render();
log.info(out);
/*
<p id="my-elem" class="card-1-dp card-red card-primary card" 	style="color:transparent;background:#fff;" data-elem="true">
??Hello, <span>World</span>.
</p>
*/

S s = new S("link");
s.clazz("mdl", "small")
.wrap(e.removeClass("card-1-dp"));

out = e.render();
L.i(out);
/*
<p id="my-elem" class="card-red card-primary card" style="color:transparent;background:#fff;" data-elem="true"><link class="small mdl" />
</p>
*/
```

```java
String out = new JSObject()
    .put("name", "Charlie")
    .put("age", 14)
    .put("adult", false)
    .put("favorite", new JSArray().add("A").add(3).add("7").add(true))
    .put("state", new JSStatement("eval('k')"))
    .put("other", new JSObject().put("mother", "Mary").put("oop", s))
    .render();
/*
{other:{mother:"Mary",oop:null},name:"Charlie",state:eval('k'),adult:false,favorite:["A",3,"7",true],age:14}
*/
```

-------

Copyright (c) 2019. Elex. All Rights Reserved.

https://www.elex-project.com/ 
