<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
	<title>Library Index Page</title>
	<link rel="stylesheet" href="<@spring.url '/css/style.css'/>">
</head>

<body class="index-body">
<div class="page-header">
	Library Index Page
</div>

<div class="page-body">
	<p>
		<h1>Project Vision</h1>
		<div class="left">
			To provide the detail and geographic information of libraries in different data formats. 
			Including the raw data format (geo-json), json-ld format (machine readable) and HTML webpages (human readable).  
		</div>
	</p>
	
	<a class="menu" href="${datasetUrl}" target="_blank">RAW Dataset</a>
	<a class="menu" href="<@spring.url '/jsonld'/>" target="_blank">JSON-LD</a>
	<a class="menu" href="<@spring.url '/list'/>" target="_blank">HTML</a>
</div>
</body>
</html>