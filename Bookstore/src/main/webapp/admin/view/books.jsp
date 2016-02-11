<section id="orders">
    <table>
        <thead>
        <tr>
            <th>book id</th>
            <th>title</th>
            <th>author</th>
            <th>language</th>
            <th>publisher</th>
            <th>format</th>
            <th>isbn</th>
            <th>pages</th>
            <th>price</th>
            <th>quantity</th>
            <th>category</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><strong>${book.id}</strong></td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.language}</td>
                <td>${book.publisher}</td>
                <td>${book.format}</td>
                <td>${book.isbn}</td>
                <td>${book.pages}</td>
                <td>${book.price}</td>
                <td>${book.quantity}</td>
                <td>${book.category.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
