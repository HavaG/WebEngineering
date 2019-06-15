<%@ include file="taglibs.jsp"%>
<link rel="stylesheet" href="CSS/header.css" />

<div id="logo">
    <img src="CSS/pictures/logo_form.png" alt="Form logo" />
    <div>
        <h1><a href="Home"><em>Poll</em>Web</a></h1>
        <h2>Take part in our surveys ...</h2>
    </div>
</div>

<nav>
    <ul>   
        <li><a href="Home">Home</a></li>
        <li><a href="Administrator">Administrator</a></li>
        <li><a href="Manager">Manager</a></li>
        <li><a href="Login"><c:out value="${log}"> </c:out></a></li>
    </ul>
</nav>
