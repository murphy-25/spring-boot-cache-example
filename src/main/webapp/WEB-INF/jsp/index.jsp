<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>${message}</h1>

	<p>Patient Selected: ${patient}</p>
	<input type="submit" name="/getPatient" value="Select Patient" />
</body>

</html>
