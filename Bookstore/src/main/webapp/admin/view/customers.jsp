<section id="orders">
    <table>
        <thead>
        <tr>
            <th>customer id</th>
            <th>name</th>
            <th>address</th>
            <th>ccNumber</th>
            <th>city</th>
            <th>email</th>
            <th>phone</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><strong>${customer.id}</strong></td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.ccNumber}</td>
                <td>${customer.cityRegion}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
