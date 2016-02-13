<section id="editbook" class="book-form">
    <form action="/admin/updatebook" method="post" class="basic-grey">
        <h1>Edit Book
            <span>Please fill all the texts in the fields.</span>
        </h1>
        <label>
            <span>Title :</span>
            <input type="hidden" name="id" value="${book.id}"/>
            <input id="title" type="text" name="title" placeholder="Title" value="${book.name}"/>
        </label>
        <label>
            <span>Author :</span>
            <input id="author" type="text" name="author" placeholder="Author" value="${book.author}"/>
        </label>
        <label>
            <span>Language :</span>
            <input id="language" type="text" name="language" placeholder="Language" value="${book.language}"/>
        </label>
        <label>
            <span>Publisher :</span>
            <input id="publisher" type="text" name="publisher" placeholder="Publisher" value="${book.publisher}"/>
        </label>
        <label>
            <span>Format :</span>
            <input id="format" type="text" name="format" placeholder="Format" value="${book.format}"/>
        </label>
        <label>
            <span>ISBN :</span>
            <input id="isbn" type="text" name="isbn" placeholder="ISBN" value="${book.isbn}"/>
        </label>
        <label>
            <span>Pages :</span>
            <input id="pages" type="text" name="pages" placeholder="Pages" value="${book.pages}"/>
        </label>
        <label>
            <span>Prise :</span>
            <input id="price" type="text" name="price" placeholder="Price" value="${book.price}"/>
        </label>
        <label>
            <span>Quantity :</span>
            <input id="quantity" type="text" name="quantity" placeholder="Quantity" value="${book.quantity}"/>
        </label>
        <label>
            <span>Category :</span>
            <select name="selection">
                <c:forEach var="category" items="${categories}">
                    <c:if test="${category.id == book.category.id}">
                        <option value="${category.id}" selected="selected">${category.name}</option>
                    </c:if>
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            <span>Release Date :</span>
            <input id="releasedate" type="month" name="releasedate" placeholder="Release Date" value="${date}"/>
        </label>
        <label>
            <span>Description :</span>
            <textarea id="description" name="description" placeholder="Description">${book.description}</textarea>
        </label>
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="Edit"/>
        </label>
    </form>
</section>
