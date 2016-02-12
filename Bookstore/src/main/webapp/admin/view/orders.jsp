<section id="orders" class="admin-tables">
    <table>
        <thead>
        <tr>
            <th>order id</th>
            <th>amount</th>
            <th>confirmation number</th>
            <th>date created</th>
            <th>customer id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><strong>${order.id}</strong></td>
                <td>${order.amount}</td>
                <td>${order.confirmationNumber}</td>
                <td>${order.dateCreated}</td>
                <td>${order.customer.id}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
