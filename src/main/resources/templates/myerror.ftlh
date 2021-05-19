<#import "macros/tagsBasic.ftlh" as basic/>
<#import "/spring.ftl" as spring />
<!doctype html>
<html>
<@basic.head title="Ошибочка вышла"></@basic.head>
<@basic.header></@basic.header>
    <body>
        <div class="center girl">
            <img src="<@spring.url '/images/error.jpg'></@spring.url>"
                 class="img-thumbnail"
                 width="200px"sizes=""
                 height="200px">
            <p class="text-center">We have problems, you broke something !!!</p>
        </div>
    </body>
</html>