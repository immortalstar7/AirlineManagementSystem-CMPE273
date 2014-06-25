<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
<script src="http://twitter.github.com/bootstrap/assets/js/bootstrap.js"></script>
<meta charset=utf-8 />
<title>JS Bin</title>
<style type="text/css">
.scrollspy-example {
  display: block;
  overflow: scroll;
  width: 300px;
  height: 200px;
}
</style>
</head>
<body>
  <div id='navbarExample'>
    <ul id='' class="nav nav-list">
      <li class='active'><a href="#one">@one</a></li>
      <li><a href="#two">@two</a></li>
      <li><a href="#three">@three</a></li>
    </ul>
  </div>
  <!-- offset='80' is the .scrollspy-example position of the body top. -->
  <div class='scrollspy-example' data-offset='80' data-spy="scroll" data-target="#navbarExample">
    <div id='one'>
      <table>
        <tbody>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
          <tr><td>1</td><td>1</td></tr>
        </tbody>
      </table>
    </div>
    <div id='two'>
      <table>
        <tbody>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
          <tr><td>2</td><td>2</td></tr>
        </tbody>
      </table>
    </div>
    <div id='three'>
      <table>
        <tbody>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
          <tr><td>3</td><td>3</td></tr>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>