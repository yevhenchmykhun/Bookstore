<div id="chart-header">Statistics</div>
<div id="chart">
    <div id="data">
        <c:forEach var="visitor" items="${visitors}">
            <span class="count">${visitor.count}</span>
        </c:forEach>
        <c:forEach var="date" items="${dates}">
            <span class="date">${date}</span>
        </c:forEach>
    </div>
</div>