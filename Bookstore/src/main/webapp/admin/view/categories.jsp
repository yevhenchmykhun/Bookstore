<section id="orders">
    <table>
        <thead>
        <tr>
            <th>category id</th>
            <th>name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td><strong>${category.id}</strong></td>
                <td>${category.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
