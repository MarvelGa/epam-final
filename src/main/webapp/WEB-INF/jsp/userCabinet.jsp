<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Home page</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>
<body style="background-color: #D8BFD8;">
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>


    <div id="content">
        <center>
            <table>
                <tr>
                    <td>

                                <h2>CALCULATOR</h2> <br>
                                <form id="formCalculate" action="./register" method="post">


                                    <div class='form-group'>
                                        <label for='ratecityfromid'>City from</label>
                                        <select class="form-control text-center" id='ratecityfromid'>
                                            <option value=''>Choose...</option>
                                            <c:forEach var="cityid" items="${distancesMap.keySet()}">
                                                <option id='cityoption${cityid}' value='${cityid}'
                                                        data-citytoid='${distancesMap.get(cityid).toCityId}'
                                                        data-citytoname='${citiesMap.get(distancesMap.get(cityid).toCityId)}'>
                                                        ${citiesMap.get(distancesMap.get(cityid).fromCityId)}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class='form-group'>
                                        <label for='ratecitytoid'>City to</label>
                                        <input type="number" id='ratecitytoid' style='display:none;'>
                                        <p class="form-control text-center" id='showcitytoname' />
                                    </div>

                                    <div class="field">
                                        <label>Choose City from:</label>
                                        <div class="input">
                                            <select name="adress">
                                                <option selected disabled>Choose your adress:</option>
                                                <option value="Kyiv" ${users.adress!=null?(users.adress.equals("Kyiv")?"selected": ""): ""}>
                                                    Kyiv
                                                </option>
                                                <option value="Odessa"${users.adress!=null?(users.adress.equals("Odessa")?"selected": ""): ""} >
                                                    Odessa
                                                </option>
                                                <option value="Lvov" ${users.adress!=null?(users.adress.equals("Lvov")?"selected": ""): ""}>
                                                    Lvov
                                                </option>
                                                <option value="Kharkiv"${users.adress!=null?(users.adress.equals("Kharkiv")?"selected": ""): ""} >
                                                    Kharkiv
                                                </option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="field">
                                        <label>Choose City to:</label>
                                        <div class="input">
                                            <select name="adress">
                                                <option selected disabled>Choose your adress:</option>
                                                <option value="Kyiv" ${users.adress!=null?(users.adress.equals("Kyiv")?"selected": ""): ""}>
                                                    Kyiv
                                                </option>
                                                <option value="Odessa"${users.adress!=null?(users.adress.equals("Odessa")?"selected": ""): ""} >
                                                    Odessa
                                                </option>
                                                <option value="Lvov" ${users.adress!=null?(users.adress.equals("Lvov")?"selected": ""): ""}>
                                                    Lvov
                                                </option>
                                                <option value="Kharkiv"${users.adress!=null?(users.adress.equals("Kharkiv")?"selected": ""): ""} >
                                                    Kharkiv
                                                </option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="rateweight">Weight</label>
                                        <input type="number" class="form-control ratefield text-center" id='rateweight'
                                               placeholder="Enter value" min='1' max='${myRate.maxWeight}' />
                                    </div>
                                    <div class="form-group">
                                        <label for="ratelength">Length</label>
                                        <input type="number" class="form-control ratefield text-center" id='ratelength'
                                               placeholder="Enter value" min='1' max='${myRate.maxLength}' />
                                    </div>
                                    <div class="form-group">
                                        <label for="ratewidth">Width</label>
                                        <input type="number" class="form-control ratefield text-center" id='ratewidth'
                                               placeholder="Enter value" min='1' max='${myRate.maxWidth}' />
                                    </div>
                                    <div class="form-group">
                                        <label for="rateheight">Height</label>
                                        <input type="number" class="form-control ratefield text-center" id='rateheight'
                                               placeholder="Enter value" min='1' max='${myRate.maxHeight}' />
                                    </div>

                                    <div class='form-group pl-3 pr-3 pb-1' id='showratecost' style='border: 2px teal solid;'>
                                        <label class='ml-2' for='ratecost'>Cost</label>
                                        <p class="form-control text-center" id='ratecost' name='ratecost'>${myRate.cost}</p>
                                    </div>
                                    <button class='btn btn-secondary text-center h3 w-100' type='submit'>Cancel</button>



                                    <div class="submit">
                                        <button type="submit">Register</button>
                                    </div>
                                </form>
                    </td>

                    <td>
                        </br></br>
                        <c:choose>
                            <c:when test="${errorObj.errorMessages!=null}">
                                <ul style="color:tomato">
                                    Error list: <br/>
                                    <c:forEach items="${errorObj.errorMessages}" var="i">
                                        <li><c:out value="${i}"/></li>
                                        <br/>
                                    </c:forEach>
                                </ul>
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </table>


            <div class="py-sm-5 py-4" style="position:relative;">
                <div class="container py-xl-5 py-lg-3">
                    <h3 class="title mb-sm-4 mb-3 text-center">
                        ${lang.Delivery}
                        ${lang.Map}
                    </h3>
                    <div class="row">
                        <div class='col-4 col-sm-4 col-md-3 col-lg-3'>
                            <h3 class='text-center'>${lang.City}</h3>
                            <input type='text' class='text-center' id='searchcity' placeholder='Type city name' minlength='3' />
                        </div>
                        <div class='col-8 col-sm-8 col-md-9 col-lg-9'>
                            <div class='row'>
                                <div class='col-12 col-sm-6 col-md-6'>
                                    <h4 class='text-center'>${lang.Available_destinations_cities}</h4>
                                    <input type='text' class='text-center' id='searchcity2' placeholder='Type city name' minlength='3' />
                                </div>
                                <div class='col-12 col-sm-6 col-md-6'>
                                    <h4 class='text-center'>${lang.Available_rates}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr class='bg-secondary' style='height:5px;'>
                    <div id='deliverymap'>
                        <c:forEach items="${deliveryMapDestinations.keySet()}" var="cityId">
                            <div class="row" id='city${cityId}'>
                                <div class='col-4 col-sm-4 col-md-3 col-lg-3 align-middle'>
                                    <h5 class='text-center city'>${cityId}</h5>
                                </div>

                                <div class='col-8 col-sm-8 col-md-9 col-lg-9'>

                                    <div class='row'>
                                        <div class='col-12 col-sm-6 col-md-6'>
                                            <c:forEach items="${deliveryMapDestinations.get(cityId)}" var="distanceModel">
                                                <p class='text-center cityto' data-cityhostname='${cityId}'>${citiesMap.get(distanceModel.toCityId)} /
                                                        ${distanceModel.distance} km
                                                </p>
                                            </c:forEach>
                                        </div>
                                        <div class='col-12 col-sm-6 col-md-6'>
                                            <c:forEach items="${deliveryMapRates.get(cityId)}" var="rateModel">
                                                <p class='text-center'><a
                                                        href='http://localhost:8080/gtc/controller?command=rates&ratename=${rateModel.name}'>
                                                        ${rateModel.name} / $ ${rateModel.cost}
                                                </a>
                                                </p>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br />
                        </c:forEach>
                    </div>
                    <div id='searchresult'>
                    </div>
                </div>
            </div>



        </center>
    </div>


</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
<center><h1>USERCabinet!</h1></center>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>