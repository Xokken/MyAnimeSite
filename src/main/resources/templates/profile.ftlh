<#import "macros/tagsBasic.ftlh" as basic/>
<#import "/spring.ftl" as spring />
<#import "macros/tagsUser.ftlh" as info/>
<!doctype html>
<html>
<@basic.head title="Профиль"></@basic.head>
<@basic.header></@basic.header>
<body>
<div class="container profile">
    <div class="center">
        <@info.profile user></@info.profile>
        <@info.btnImg></@info.btnImg>
        <div style="width: 450px">
            <p>QUOTE!!!</p>
            <p>Anime: ${quote.anime}</p>
            <p>Person: ${quote.character}</p>
            <p>${quote.quote}</p>
        </div>
    </div>
    <div class="container container-girls">
        <#list personList as person>
            <div class="center girl">
                <td><img src="http://127.0.0.1:8887/${person.img}"
                         class="img-thumbnail"
                         width="200px"sizes=""
                         height="200px"></td>
                <p class="text-center">${person.name}</p>
                <p class="text-center">${person.world}</p>
                <p class="text-center">Type weapon: ${person.equipment.type}</p>
                <p class="text-center">Name: ${person.equipment.name}</p>
                <form action="/profile" method="post" hidden="true" id="${person.name}">
                    <input type="text" name="id" value="${person.id}" hidden="true">
                    <input type="text" name="name" value="${person.name}" hidden="true">
                    <input type="text" name="world" value="${person.img}" hidden="true">
                    <input type="text" name="img" value="${person.world}" hidden="true">
                </form>
                <button form="${person.name}" type="submit" type="button" class="btn btn-danger">Отказаться</button>
            </div>
        </#list>
    </div>
</div>
</body>
</html>