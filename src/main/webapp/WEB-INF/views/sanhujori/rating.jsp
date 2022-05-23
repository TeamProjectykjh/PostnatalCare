<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

fieldset, label { margin: 0; padding: 0; }

.rating { 
  border: none;
  float: left;
}

.rating > input { display: none; } 
.rating > label:before { 
  margin: 5px;
  font-size: 1.25em;
  font-family: FontAwesome;
  display: inline-block;
  content: "\f005";
}

.rating > .half:before { 
  content: "\f089";
  position: absolute;
}

.rating > label { 
  color: #ddd; 
 float: right; 
}

.rating > input:checked ~ label, /* show gold star when clicked */
.rating:not(:checked) > label:hover, /* hover current star */
.rating:not(:checked) > label:hover ~ label { color: #FFD700;  } /* hover previous stars in list */

.rating > input:checked + label:hover, /* hover current star when changing rating */
.rating > input:checked ~ label:hover,
.rating > label:hover ~ input:checked ~ label, /* lighten current selection */
.rating > input:checked ~ label:hover ~ label { color: #FFED85;  } 
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ratingsave" method="post">
	<fieldset class="rating">
	    <input type="radio" id="star5" name="rating" value="5" />
	    <label class = "full" for="star5"></label>
	    
	    <input type="radio" id="star4half" name="rating" value="4.5" />
	    <label class="half" for="star4half"></label>
	    
	    <input type="radio" id="star4" name="rating" value="4" />
	    <label class = "full" for="star4"></label>
	    
	    <input type="radio" id="star3half" name="rating" value="3.5" />
	    <label class="half" for="star3half"></label>
	    
	    <input type="radio" id="star3" name="rating" value="3" />
	    <label class = "full" for="star3"></label>
	    
	    <input type="radio" id="star2half" name="rating" value="2.5" />
	    <label class="half" for="star2half"></label>
	    
	    <input type="radio" id="star2" name="rating" value="2" />
	    <label class = "full" for="star2"></label>
	    
	    <input type="radio" id="star1half" name="rating" value="1.5" />
	    <label class="half" for="star1half" title="Meh - 1.5 stars"></label>
	    
	    <input type="radio" id="star1" name="rating" value="1" />
	    <label class = "full" for="star1"></label>
	    
	    <input type="radio" id="starhalf" name="rating" value="0.5" />
	    <label class="half" for="starhalf"></label>
	</fieldset>
	<br>
	<textarea rows="6" cols="50" name="content" placeholder="간단한 후기를 작성해주세요."></textarea>   
	<br>
	<input type="submit" value="작성">
</form>
</body>
</html>