<section id="categories" class="admin-tables">
    <table>
        <thead>
        <tr>
            <th>category id</th>
            <th>name</th>
            <th>actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td><strong>${category.id}</strong></td>
                <td>${category.name}</td>
                <td>
                    <form action="/admin/deletecategory" method="post">
                        <input type="hidden" name="categoryId" value="${category.id}"/>
                        <input type="submit" class="button" value="Delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
