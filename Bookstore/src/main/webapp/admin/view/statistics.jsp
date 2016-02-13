<div id="chart-header">Statistics</div>
<div id="chart">
    <div id="data">
        <c:forEach var="visitor" items="${visitors}">
            <span class="date">${visitor.date}</span>
            <span class="count">${visitor.count}</span>
        </c:forEach>
    </div>
</div>