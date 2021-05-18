<#import "macros/tagsBasic.ftlh" as basic>
<#import "/spring.ftl" as spring />
<#import "macros/tagsUser.ftlh" as info/>
<!doctype html>
<html>
<@basic.head title="Главная"></@basic.head>
<@basic.header></@basic.header>
<body>
    <div class="container profile">
        <div class ="worlds">
            <#list worldList as world>
                <form style="margin-top: 10px" action="/persons" method="get" id="${world.name}">
                    <ul class="list-group list-group-horizontal">
                        <li class="list-group-item">
                            <td><img src="<@spring.url '/images/${world.img}'></@spring.url>"
                                     class="img-thumbnail"
                                     width="200px"sizes=""
                                     height="200px"></td>
                            <input type="text" name="worldName" value="${world.name}" hidden="true">
                            <button form="${world.name}" type="submit" type="button" class="btn btn-danger">${world.name}</button>
                        </li>
                    </ul>
                </form>
            </#list>
        </div>
        <div class="center">
            <@info.profile user></@info.profile>
        </div>
    </div>
</body>

</html>