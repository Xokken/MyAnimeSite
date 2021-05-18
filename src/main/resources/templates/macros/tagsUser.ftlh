<#macro btnImg>
    <form action="upload" method="post"  enctype="multipart/form-data">
        <p>Сменить аватар</p>
        <input type="file" accept="image/*" name="file">
        <input type="submit" id="blabla" value="Отправить">
    </form>
</#macro>


<#macro profile user>
    <img src="http://127.0.0.1:8887/${user.img}"
         class="img-thumbnail"
         width="200px"
         sizes=""
         height="200px">
    <p class="text">Имя: ${user.name}</p>
    <p class="text">Почта: ${user.email}</p>
    <p class="text">Возраст: ${user.age}</p>
</#macro>