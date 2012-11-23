<html>
<head>
    <title>Please upgrade your browser</title>
	<style type="text/css">
		#outerWrapper {
			text-align:center;
		}
		#innerWrapper {
			width:480px; margin:auto;
			text-align:left;
		}
		
		tbody td { text-align:center; vertical-align:bottom; height:150px;}
		
		tfoot td {font-size:small;}
	</style>
</head>
<body>
	<div id="outerWrapper">
		<div id="innerWrapper">
		    <h1>You need to upgrade your browser to use this website</h1>
		    <p>You have Internet Explorer 6. This browser is not compatible with modern web sites.</p>
   
		    <h2>Choose a new browser (they're all free)</h2>
   			<table width="100%" border="0" cellpadding="4" cellspacing="0" align="center">
   				<tbody>
   					<tr>
   						<td>
							<a href="http://www.apple.com/safari/download/"><img src="${g.resource(plugin:'lamerFilter', dir:'images', file:'safari48.gif').encodeAsHTML()}"></a>
							<h3>Safari</h3>
						</td>
   						<td>
							<a href="http://www.google.com/chrome"><img src="${g.resource(plugin:'lamerFilter', dir:'images', file:'chrome48.gif').encodeAsHTML()}"></a>
							<h3>Chrome</h3>
						</td>
   						<td>
							<a href="http://www.mozilla.com/firefox"><img src="${g.resource(plugin:'lamerFilter', dir:'images', file:'firefox48.gif').encodeAsHTML()}"></a>
							<h3>Firefox</h3>
						</td>
						<td>
							<a href="http://www.opera.com/download"><img src="${g.resource(plugin:'lamerFilter', dir:'images', file:'opera48.gif').encodeAsHTML()}"></a>
							<h3>Opera</h3>
						</td>
   					</tr>
   				</tbody>
				<tfoot>
					<tr>
						<td colspan="4"><p>Alternatively: <g:link url="${params.originalLink}">I want to carry on using the website even though it is unlikely to work.</g:link></p></td>
					</tr>
				</tfoot>
   			</table>
		</div>
	</div>
</body>
</html>