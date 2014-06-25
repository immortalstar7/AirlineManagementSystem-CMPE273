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
<script type="text/javascript">
$(document).ready(function(){

  //how much items per page to show
  var show_per_page = 5; 
  //getting the amount of elements inside content div
  var number_of_items = $('#content').children().size();
  //calculate the number of pages we are going to have
  var number_of_pages = Math.ceil(number_of_items/show_per_page);

  //set the value of our hidden input fields
  $('#current_page').val(0);
  $('#show_per_page').val(show_per_page);

  var navigation_html = '<ul>';

  navigation_html += '<li class="previous_link">';
  navigation_html += '<a href="javascript:previous();">&larr; Previous</a>';
  navigation_html += '</li>';
  var current_link = 0;
  while(number_of_pages > current_link){
    navigation_html += '<li class="page_link" id="id' + current_link +'">';
    navigation_html += '<a href="javascript:go_to_page(' + current_link +')" longdesc="' + current_link +'">'+ (current_link + 1) +'</a>';
    current_link++;
    navigation_html += '</li>';
  }
  navigation_html += '<li>';
  navigation_html += '<a class="next_link" href="javascript:next();">Next &rarr;</a>';
  navigation_html += '</li>';
  navigation_html += '</ul>';

  $('#page_navigation').html(navigation_html);

  //add active class to the first page link
  $('#page_navigation .page_link:first').addClass('active');

  //hide all the elements inside content div
  $('#content').children().css('display', 'none');

  //and show the first n (show_per_page) elements
  $('#content').children().slice(0, show_per_page).css('display', 'block');

});

function previous(){

  new_page = parseInt($('#current_page').val()) - 1;
  //if there is an item before the current active link run the function
  if($('.active').prev('.page_link').length==true){
    go_to_page(new_page);
  }

}

function next(){
  new_page = parseInt($('#current_page').val()) + 1;
  //if there is an item after the current active link run the function
  if($('.active').next('.page_link').length==true){
    go_to_page(new_page);
  }

}

function go_to_page(page_num){
  //get the number of items shown per page
  var show_per_page = parseInt($('#show_per_page').val());

  //get the element number where to start the slice from
  start_from = page_num * show_per_page;

  //get the element number where to end the slice
  end_on = start_from + show_per_page;

  activate_id = page_num;
  var get_box = document.getElementById("id"+page_num);
  //hide all children elements of content div, get specific items and show them
  $('#content').children().css('display', 'none').slice(start_from, end_on).css('display', 'block');

  /*get the page link that has longdesc attribute of the current page and add active class to it
  and remove that class from previously active page link*/
  $("#page_navigation").find('li.active').removeClass("active");
  $(get_box).addClass("active");


  //update the current page input field
  $('#current_page').val(page_num);
}

</script>

<style>
.page_navigation a{
	padding:3px;
	border:1px solid gray;
	margin:2px;
	color:black;
	text-decoration:none
}
.active{
	background:darkblue;
	color:white !important;
}
</style>
</head>
<body>
  <input type='hidden' id='current_page' />

	<input type='hidden' id='show_per_page' />
  <!-- offset='80' is the .scrollspy-example position of the body top. -->
  <div id="content" >
   <div class="post">
			<h1>1</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
			<p>Vestibulum consectetur ipsum sit amet urna euismod imperdiet aliquam urna laoreet.</p>
			<p>Curabitur a ipsum ut elit porttitor egestas non vitae libero.</p>
			<p>Pellentesque ac sem ac sem tincidunt euismod.</p>
		</div>

		<div class="post">
			<h1>2</h1>
			<p>Duis hendrerit purus vitae nibh tincidunt bibendum.</p>
			<p>Nullam in nisi sit amet velit placerat laoreet.</p>
			<p>Vestibulum posuere ligula non dolor semper vel facilisis orci ultrices.</p>
			<p>Donec tincidunt lorem et dolor fringilla ut bibendum lacus fringilla.</p>
			<p>In non eros eu lacus vestibulum sodales.</p>
			<p>Duis ultrices metus sit amet sem adipiscing sit amet blandit orci convallis.</p>
		</div>

		<div class="post">
			<h1>3</h1>
			<p>Proin ullamcorper est vitae lorem mollis bibendum.</p>
			<p>Maecenas congue fringilla enim, tristique laoreet tortor adipiscing eget.</p>
			<p>Duis imperdiet metus et lorem venenatis nec porta libero porttitor.</p>
			<p>Maecenas lacinia lectus ac nulla commodo lacinia.</p>
			<p>Maecenas quis massa nisl, sed aliquet tortor.</p>
			<p>Quisque porttitor tellus ut ligula mattis luctus.</p>
		</div>

		<div class="post">
			<h1>4</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>

		<div class="post">
			<h1>5</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>

		<div class="post">
			<h1>6</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>

		<div class="post">
			<h1>7</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>


		<div class="post">
			<h1>8</h1>
			<p>Morbi hendrerit ultrices enim, ac rutrum felis commodo in.</p>
			<p>Suspendisse sagittis mattis sem, sit amet faucibus nisl fermentum vitae.</p>
			<p>Nulla sed purus et tellus convallis scelerisque.</p>
			<p>Nam at justo ut ante consectetur faucibus.</p>
			<p>Proin dapibus nisi a quam interdum lobortis.</p>
			<p>Nunc ornare nisi sed mi vehicula eu luctus mauris interdum.</p>
			<p>Mauris auctor suscipit tellus, at sodales nisi blandit sed.</p>
		</div>

		<div class="post">
			<h1>9</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
			<p>Vestibulum consectetur ipsum sit amet urna euismod imperdiet aliquam urna laoreet.</p>
			<p>Curabitur a ipsum ut elit porttitor egestas non vitae libero.</p>
			<p>Pellentesque ac sem ac sem tincidunt euismod.</p>
		</div>

		<div class="post">
			<h1>10</h1>
			<p>Duis hendrerit purus vitae nibh tincidunt bibendum.</p>
			<p>Nullam in nisi sit amet velit placerat laoreet.</p>
			<p>Vestibulum posuere ligula non dolor semper vel facilisis orci ultrices.</p>
			<p>Donec tincidunt lorem et dolor fringilla ut bibendum lacus fringilla.</p>
			<p>In non eros eu lacus vestibulum sodales.</p>
			<p>Duis ultrices metus sit amet sem adipiscing sit amet blandit orci convallis.</p>
		</div>

		<div class="post">
			<h1>11</h1>
			<p>Proin ullamcorper est vitae lorem mollis bibendum.</p>
			<p>Maecenas congue fringilla enim, tristique laoreet tortor adipiscing eget.</p>
			<p>Duis imperdiet metus et lorem venenatis nec porta libero porttitor.</p>
			<p>Maecenas lacinia lectus ac nulla commodo lacinia.</p>
			<p>Maecenas quis massa nisl, sed aliquet tortor.</p>
			<p>Quisque porttitor tellus ut ligula mattis luctus.</p>
		</div>

		<div class="post">
			<h1>12</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>

		<div class="post">
			<h1>13</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>

		<div class="post">
			<h1>14</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>

		<div class="post">
			<h1>15</h1>
			<p>In at mi dolor, at consectetur risus.</p>
			<p>Etiam id erat ut lorem fringilla dictum.</p>
			<p>Curabitur sagittis dolor ac nisi interdum sed posuere tellus commodo.</p>
			<p>Pellentesque quis magna vitae quam malesuada aliquet.</p>
			<p>Curabitur tempus tellus quis orci egestas condimentum.</p>
			<p>Maecenas laoreet eros ac orci adipiscing pharetra.</p>
		</div>


		<div class="post">
			<h1>16</h1>
			<p>Morbi hendrerit ultrices enim, ac rutrum felis commodo in.</p>
			<p>Suspendisse sagittis mattis sem, sit amet faucibus nisl fermentum vitae.</p>
			<p>Nulla sed purus et tellus convallis scelerisque.</p>
			<p>Nam at justo ut ante consectetur faucibus.</p>
			<p>Proin dapibus nisi a quam interdum lobortis.</p>
			<p>Nunc ornare nisi sed mi vehicula eu luctus mauris interdum.</p>
			<p>Mauris auctor suscipit tellus, at sodales nisi blandit sed.</p>
		</div>


  </div>
  <div id='page_navigation' class="pagination"></div>
</body>
</html>