<c:forEach var="book" items="${books}">
    <div class="category-exposition">
        <a href="<c:url value='/description'/>?id=${book.id}"/>
        <div class="book-image">
            <img src="<c:url value='${initParam.relativeCoversPath}${book.cover}'/>">
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


<div class="pagination">
    <ul>
        <%--For displaying Previous link except for the 1st page --%>
        <c:if test="${currentPage != 1}">
            <li><a href="<c:url value='/category'/>?id=${categoryId}&page=${currentPage - 1}">Previous</a></li>
        </c:if>

        <%--For displaying Page numbers.
        The when condition does not display a link for the current page--%>
                <c:forEach begin="1" end="${numberOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <li id="active"><a href="">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value='/category'/>?id=${categoryId}&page=${i}">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

        <%--For displaying Next link --%>
        <c:if test="${currentPage lt numberOfPages}">
            <li><a href="<c:url value='/category'/>?id=${categoryId}&page=${currentPage + 1}">Next</a></li>
        </c:if>
    </ul>
</div>

