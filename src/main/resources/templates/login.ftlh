<#import "macros/tagsBasic.ftlh" as basic>
<#import "/spring.ftl" as spring />
<!doctype html>
<html>
<@basic.head title="Регистрация"></@basic.head>
<body class="center">
<#if message??>
    <p>${message}</p>
</#if>
<@basic.formReg></@basic.formReg>
</body>
</html>