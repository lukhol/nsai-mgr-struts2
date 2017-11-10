<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	 <script src="views/js/foundation.min.js"></script>
	 <script src="views/js/subjectList.js"></script>
	 <link rel="stylesheet" type="text/css" href="views/css/foundation.min.css">
	 <link rel="stylesheet" type="text/css" href="views/css/subjectList.css">
</head>
<body>
	<h1>List of notes (static content  for tests):</h1>
	<table>
  <thead>
    <tr>
      <th width="200">Nazwa przedmiotu</th>
      <th width="100">Liczba uczniów</th>
	  <th></th>
    </tr>
  </thead>
  <tbody>
    <tr class="przedmioty">
      <td>Matematyka</td>
      <td>26</td>
	  <td class="uczniowie">
		<table>
			<thead>
				<tr>
					<th width="100">Imie ucznia</th>
					<th width="150">Nazwisko ucznia</th>
					<th></th>
				<tr>
			</thead>
			<tbody>
				<tr>
					<td>Andrzej</td>
					<td>Kowalski</td>
					<td>...</td>
				</tr>
			</tbody>
		</table>	
	  </td>
    </tr>
	<tr class="przedmioty">
      <td>Język polski</td>
      <td>14</td>
	  <td class="uczniowie">
		<table>
			<thead>
				<tr>
					<th width="100">Imie ucznia</th>
					<th width="150">Nazwisko ucznia</th>
					<th></th>
				<tr>
			</thead>
			<tbody>
				<tr>
					<td>Andrzej</td>
					<td>Kowalski</td>
					<td>...</td>
				</tr>
			</tbody>
		</table>	
	  </td>
    </tr>
	<tr class="przedmioty">
      <td>Biologia</td>
      <td>17</td>
	  <td class="uczniowie">
		<table>
			<thead>
				<tr>
					<th width="100">Imie ucznia</th>
					<th width="150">Nazwisko ucznia</th>
					<th></th>
				<tr>
			</thead>
			<tbody>
				<tr>
					<td>Andrzej</td>
					<td>Kowalski</td>
					<td>...</td>
				</tr>
			</tbody>
		</table>	
	  </td>
    </tr>
  </tbody>
</table>

</body>
</html>
