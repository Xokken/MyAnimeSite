<#macro head title>
    <#import "tagsBasic.ftlh" as tags>
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style><@tags.style></@tags.style></style>
    </head>
</#macro>

<#macro header>
    <header>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active" href="/main">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/profile">Профиль</a>
            </li>
            <form action="/logout" method="get" hidden="true" id="log">
            </form>
            <button form="log" type="submit" name="logout" value="logout" type="button" class="btn btn-danger">Выход</button>
        </ul>
    </header>
</#macro>


<#macro formReg>
    <div class="btn-group btn-group-toggle" data-toggle="buttons">
        <label class="btn btn-primary active btn1">
            <input type="radio" name="options" id="option1" checked> Вход
        </label>
        <label class="btn btn-primary btn2">
            <input type="radio" name="options" id="option2"> Регистрация
        </label>
    </div>
    <div class="reg">
        <form action="/signup" method="post">
            <div class="form-group">
                <label for="inputName1">Your name</label>
                <input type="text" class="form-control" name="name" id="inputName1" required>
            </div>
            <div class="form-group col-md-6">
                <label for="inputEmail1">Email</label>
                <input type="email" class="form-control" name="email" id="inputEmail1" required>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputPassword1">Password</label>
                    <input type="password" class="form-control" name="password1" id="inputPassword1" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword3">Password</label>
                    <input type="password" class="form-control" name="password2" id="inputPassword3" required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputAge1">Your age</label>
                <input type="number" class="form-control" name="age" min="6" max="108" id="inputAge1" required>
            </div>
            <button type="submit" class="btn btn-primary">Sign up</button>
        </form>
    </div>
    <div class="log">
        <form action="/signin" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail2">Email</label>
                    <input type="email" class="form-control" name="email" id="inputEmail2" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword6">Password</label>
                    <input type="password" class="form-control" name="password" id="inputPassword6" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Log in</button>
        </form>
    </div>
    <script> $(document).ready(function () {
            $(".reg").hide();
            $(".btn2").click(function () {
                $(".log").hide();
                $(".reg").show()
            });
            $(".btn1").click(function () {
                $(".reg").hide();
                $(".log").show()
            });
        });</script>
</#macro>

<#macro style>
    .center {
    text-align: center;
    }

    .container {
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: space-between;
    margin-top: 15px;
    }

    .girl{
    margin: 10px;
    }

    .container-girls{
    flex-wrap:wrap;
    justify-content: center;
    margin-bottom: 15px;
    }

    .main{
    justify-content: space-between;
    }


    .text, p {
    color: #4c4a37; font-family: ‘Source Sans Pro’, sans-serif; font-size: 18px; line-height: 32px;
    margin-right: 10px;
    }

    p {
    margin: 0 0 10px;
    }


    body{
    background: #3F92D2;
    margin-top: 30px;
    margin-left: 180px;
    margin-right: 180px;
    }

    footer{
    background:#25567B;
    }


    .nav-link, a{
    color: #FF4900;
    }

    img {
    max-height: 200px;
    width: auto;
    }

    .worlds{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin: 10px;
    }
</#macro>