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
<title>어류 분류 정보</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<%=cp%>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.node {
	cursor: pointer;
}

.node:hover {
	stroke: #000;
	stroke-width: 1.5px;
}

.node--leaf {
	fill: white;
}

.label {
	font: 11px "Helvetica Neue", Helvetica, Arial, sans-serif;
	text-anchor: middle;
	text-shadow: 0 1px 0 #fff, 1px 0 0 #fff, -1px 0 0 #fff, 0 -1px 0 #fff;
}

.label, .node--root, .node--leaf {
	pointer-events: none;
}
</style>
</head>
<body>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
	<script>
		var margin = 20, diameter = 960;

		var color = d3.scale.linear().domain([ -1, 5 ]).range(
				[ "hsl(152,80%,80%)", "hsl(228,30%,40%)" ]).interpolate(
				d3.interpolateHcl);

		var pack = d3.layout.pack().padding(2).size(
				[ diameter - margin, diameter - margin ]).value(function(d) {
			return d.size;
		})

		var svg = d3.select("body").append("svg").attr("width", diameter).attr(
				"height", diameter).append("g").attr("transform",
				"translate(" + diameter / 2 + "," + diameter / 2 + ")");

		d3.json("<%=cp%>/resources/test.json", function(error, root) {
			if (error)
				throw error;

			var focus = root, nodes = pack.nodes(root), view;

			var circle = svg.selectAll("circle").data(nodes).enter().append(
					"circle").attr(
					"class",
					function(d) {
						return d.parent ? d.children ? "node"
								: "node node--leaf" : "node node--root";
					}).style("fill", function(d) {
				return d.children ? color(d.depth) : null;
			}).on("click", function(d) {
				if (focus !== d)
					zoom(d), d3.event.stopPropagation();
			});

			var text = svg.selectAll("text").data(nodes).enter().append("text")
					.attr("class", "label").style("fill-opacity", function(d) {
						return d.parent === root ? 1 : 0;
					}).style("display", function(d) {
						return d.parent === root ? null : "none";
					}).text(function(d) {
						return d.name;
					});

			var node = svg.selectAll("circle,text");

			d3.select("body").style("background", color(-1)).on("click",
					function() {
						zoom(root);
					});

			zoomTo([ root.x, root.y, root.r * 2 + margin ]);

			function zoom(d) {
				var focus0 = focus;
				focus = d;

				var transition = d3.transition().duration(
						d3.event.altKey ? 7500 : 750).tween(
						"zoom",
						function(d) {
							var i = d3.interpolateZoom(view, [ focus.x,
									focus.y, focus.r * 2 + margin ]);
							return function(t) {
								zoomTo(i(t));
							};
						});

				transition.selectAll("text").filter(
						function(d) {
							return d.parent === focus
									|| this.style.display === "inline";
						}).style("fill-opacity", function(d) {
					return d.parent === focus ? 1 : 0;
				}).each("start", function(d) {
					if (d.parent === focus)
						this.style.display = "inline";
				}).each("end", function(d) {
					if (d.parent !== focus)
						this.style.display = "none";
				});
			}

			function zoomTo(v) {
				var k = diameter / v[2];
				view = v;
				node.attr("transform", function(d) {
					return "translate(" + (d.x - v[0]) * k + "," + (d.y - v[1])
							* k + ")";
				});
				circle.attr("r", function(d) {
					return d.r * k;
				});
			}
		});

		d3.select(self.frameElement).style("height", diameter + "px");
	</script>

</body></html>