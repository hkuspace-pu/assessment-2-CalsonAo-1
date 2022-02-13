<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
	<title>Library List</title>
	<link rel="stylesheet" href="<@spring.url '/css/style.css'/>">
</head>

<body>
<div class="center">
	<table id="library">
		<tr>
			<th>#</th>
			<th>Library Name</th>
			<th>Address</th>
			<th>Post Code</th>
			<th>Latitude / Longitude</th>
			<th>Website</th>
		</tr>

		<#list libraryList as tmpLibrary>
			<tr>
				<td>
					${tmpLibrary.fid}
				</td>
				<td>
					${tmpLibrary.libraryName}
				</td>
				<td>
					${tmpLibrary.addressLine1}
					
					<#if tmpLibrary.addressLine2??>
						, ${tmpLibrary.addressLine2}
					</#if>
					
					<#if tmpLibrary.addressLine3??>
						, ${tmpLibrary.addressLine3}
					</#if>
				</td>
				<td>
					${tmpLibrary.postcode}
				</td>
				<td>
					(${tmpLibrary.latitude}, ${tmpLibrary.longitude})
				</td>
				<td>
					<a href="${tmpLibrary.website}" target="_blank">${tmpLibrary.website}</a>
					
				</td>
			</tr>
		</#list>
	</table>
</div>
</body>
</html>