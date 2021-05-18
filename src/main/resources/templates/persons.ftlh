<#import "macros/tagsBasic.ftlh" as basic>
<#import "/spring.ftl" as spring />
<!doctype html>
<html>
<@basic.head title="Персонажи"></@basic.head>
<@basic.header></@basic.header>
<body>
<div class="container container-girls">
    <#list personList as person>
        <div class="center girl">
            <td><img src="http://127.0.0.1:8887/${person.img}"
                     class="img-thumbnail"
                     width="200px"
                     height="200px"></td>
            <p>${person.name}</p>
            <form action="/persons" id="${person.name}" method="post">
                <input type="text" name="id" value="${person.id}" hidden="true">
                <input type="text" name="name" value="${person.name}" hidden="true">
                <input type="text" name="world" value="${person.world}" hidden="true">
                <input type="text" name="img" value="${person.img}" hidden="true">
                <select class="custom-select" name="tag">
                    <option disabled selected="selected" >Выберите действие</option>
                    <option value="True">Сделать своим персонажем!</option>
                    <option value="False">Убрать из своих!</option>
                    <input type="submit" value="Принять">
                </select>
            </form>
            <button id="${person.id}" type="button" class="btn btn-info">Info equipment</button>
            <div id="equipment${person.id}" style="margin-top: 10px"></div>
            <script>
                $(document).ready(function(){
                    $('#${person.id}').click(function (){
                        $('#equipment${person.id}').html('');
                        $.ajax({
                            type: 'GET',
                            url: '/equipment/${person.equipment.id}',
                            dataType : "json",
                            success: function (data) {
                                $.each(data, function (key, value) {
                                    if (key !== 'id') {
                                        $('#equipment${person.id}').append($('<p></p>').html(value))
                                    }
                                });
                            }
                        });
                    });
                })
            </script>
        </div>
    </#list>
</div>
</body>
</html>