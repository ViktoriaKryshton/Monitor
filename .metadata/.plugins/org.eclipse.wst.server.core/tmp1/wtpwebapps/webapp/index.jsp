<%@ page language="java" contentType="text/html; chatset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script type="text/javascript"	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"	src="http://people.iola.dk/olau/flot/jquery.flot.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function load() {
		$.ajax({
			url : 'controller',
			type : "POST",
			success : function(json) {
				if (json != null) {
					var data = JSON.parse(json);
					if (data.ramRecords != null) {

						var d1 = [ null ];
						$.plot($("#placeholder1"), [ d1 ]);

						for (var i = 0; i < data.ramRecords.length; i += 1)
							d1.push([i,data.ramRecords[i].available/1000000000]);

						$.plot($("#placeholder1"), [ {
							data : d1,
							lines : {
								steps : true
							}
						} ]);
					}
					if (data.cpuRecords != null) {

						var d1 = [ null ];
						$.plot($("#placeholder2"), [ d1 ]);

						for (var i = 0; i < data.cpuRecords.length; i += 1)
							d1.push([i,	data.cpuRecords[i].available/10000000000 ]);

						$.plot($("#placeholder2"), [ {
							data : d1,
							lines : {
								steps : true
							}
						}]);
					}
				}
			},
			error : function(json) {
			}
		});
	}
</script>


</head>
<body>

	<script>
		var d1 = [ null ];
		$(document).ready(function() {
			$.plot($("#placeholder1"), [ d1 ]);
		});
		$(document).ready(function() {
			$.plot($("#placeholder2"), [ d1 ]);
		});

		$(document).ready(function() {
			setInterval(load, 1000);
		});
	</script>

	<div class="container">
		<form>

			<ul class="nav nav-tabs">
				<li class="active"><a href="#ram" data-toggle="tab">RAM</a></li>
				<li><a href="#cpu" data-toggle="tab">CPU</a></li>
			</ul>

			<div class="tab-content">
				<div role="tabpanel" class="tab-pane" id="ram">
					<h1>График количества свободной оперативной память:</h1>
					<div id="placeholder1" style="width: 600px; height: 300px;"></div>
				</div>
				<div role="tabpanel" class="tab-pane" id="cpu">
					<h1>График количества процессорного времени:</h1>
					<div id="placeholder2" style="width: 600px; height: 300px;"></div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>