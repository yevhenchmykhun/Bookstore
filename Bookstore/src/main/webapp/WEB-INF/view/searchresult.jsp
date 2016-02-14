<c:forEach var="book" items="${books}">
    <div class="category-exposition">
        <a href="<c:url value='/description'/>?id=${book.id}"/>
        <div class="book-image">
            <img src="http://place-hold.it/160x240">
        </div>
        <div class="category-info-block">
            <div class="category-info-header">
                    ${book.name}<br/>
                by ${book.author}
            </div>
            <div class="category-info">
                ISBN: ${book.isbn}<br/>
                Release Date: ${book.releaseDate}<br/>
                Publisher: ${book.publisher}<br/>
            </div>
        </div>
        </a>
    </div>
</c:forEach>
