<%@ page pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/simple-model2-board/index.do">중앙HTA</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="${cp eq 'list' ? 'active' : '' }"><a href="/home-football/list.home">경기보기</a></li>
      <li class="${cp eq 'add' ? 'active' : '' }"><a href="/home-football/addform.home">경기추가</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">

    </ul>
  </div>
</nav>