<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Taxonomic Biodiversity in Zoological Institutions</title>
<link rel="stylesheet" type="text/css"
	href="<%=cp%>/resources/css/biodiversity.css">
<link
	href='http://fonts.googleapis.com/css?family=Oswald:300,700|Open+Sans:400italic,400,700'
	rel='stylesheet' type='text/css'>
<script src="<%=cp%>/resources/script/d3.js"></script>

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-24583474-1', 'auto');
	ga('send', 'pageview');
</script>

</head>
<body>
	<div id="container">
		<div id="sidebarContainer">
			<div id="header">
				<img src="bio_header.png">
				<h1>Taxonomic Biodiversity</h1>
				<h2>in Large Zoological Institutions</h2>
			</div>
			<div id="instructions">
				<h3>Instructions:</h3>
				<p>Select an institution from the list below to update the
					taxonomic tree. Choose the appropriate color scheme to view animals
					by taxonomic hierarchy, IUCN status, or population trend in the
					wild. Mouse over any taxon to compare how many species of that
					taxon appear at each of the 4 listed institutions. Please view
					fullscreen. Press "ctrl" + "+" or "ctrl" + "-" to make the browser
					window larger or smaller as necessary.</p>
				<p>
					All data is from the <a href="http://www2.isis.org/Pages/Home.aspx"
						target="_blank">International Species Information System</a>
					(ISIS) (via <a href="http://globalspecies.org/" target="_blank">globalspecies.org</a>)
					and the <a href="http://www.iucnredlist.org" target="_blank">Red
						List of Threatened Species</a> documented by the International Union
					for Conservation of Nature. The data reflects those animals that
					each institution chose to report to ISIS.
				</p>
			</div>
			<div id="institutions">
				<div id="institutions_select">
					<h3>Institutions:</h3>
					<label><input name="inst" id="all" type="radio" checked>
						All</label> <label><input name="inst" id="bro" type="radio">
						Bronx Zoo <span class="location">(Bronx, NY)</span></label> <label><input
						name="inst" id="hen" type="radio"> Henry Doorly Zoo <span
						class="location">(Omaha, NE)</span></label> <label><input
						name="inst" id="san" type="radio"> San Diego Zoo <span
						class="location">(San Diego, CA)</span></label> <label><input
						name="inst" id="tor" type="radio"> Toronto Zoo <span
						class="location">(Toronto, ON)</span></label>
				</div>
				<div id="institutions_label"></div>
				<div id="institutions_bars_container">
					<div id="institutions_bars"></div>
					<div id="institutions_bars_2">
						<div class="bar"></div>
						<div class="bar"></div>
						<div class="bar"></div>
						<div class="bar"></div>
					</div>
				</div>
				<div id="institutions_numbers"></div>
			</div>
			<div id="colorScheme">
				<h3>Color Scheme:</h3>
				<div id="colorScheme_taxonomy">
					<label><input name="colorScheme" id="tax" type="radio"
						checked> Taxonomy</label>
					<ul>
						<li id="phylumBox">Phylum</li>
						<li id="classBox">Class</li>
						<li id="orderBox">Order</li>
						<li id="familyBox">Family</li>
						<li id="genusBox">Genus</li>
						<li id="speciesBox">Species</li>
					</ul>
				</div>
				<div id="colorScheme_iucnStat">
					<label><input name="colorScheme" id="stat" type="radio">
						IUCN Status</label>
					<ul>
						<li id="EWBox">Extinct in the wild</li>
						<li id="CRBox">Critically endangered</li>
						<li id="ENBox">Endangered</li>
						<li id="VUBox">Vulnerable</li>
						<li id="NTBox">Near threatened</li>
						<li id="LCBox">Least concern</li>
						<li id="DDBox">Data deficient / Not evaluated</li>
					</ul>
				</div>
				<div id="colorScheme_popTrend">
					<label><input name="colorScheme" id="pop" type="radio">
						Population Trend in the Wild</label>
					<ul>
						<li id="popInBox">Increasing</li>
						<li id="popStBox">Stable</li>
						<li id="popDeBox">Decreasing</li>
						<li id="popUnBox">Unknown</li>
					</ul>
				</div>
			</div>
			<div id="copyright">
				<p>Copyright © 2014 Andrew Tubelli. All Rights Reserved.</p>
			</div>
			<div></div>
			<div id="tree">
				<div id="explanation" style="visibility: hidden;">
					<span id="taxon"></span><br /> <span id="sciname"></span><br /> <span
						id="commonname"></span>
				</div>
			</div>
			<div id="totalNumberContainer">
				<span id="totalNumber"></span><br /> <span id="speciesText">
			</div>
		</div>
		<script type="text/javascript" src="<%=cp%>/resources/script/biodiversity.js"></script>
</body>
</html>
