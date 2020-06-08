$(function() {
    var vue = new Vue({
        el: "#section_left",
        data: {
            objs: [],
            page_bar: {}

        },
        methods: {
            createObj: function (img, title, content, read, conment, like,tags) {
                var obj = new Object;
                obj.img = img;
                obj.title = title;
                obj.content = content;
                obj.read = read;
                obj.conment = conment;
                obj.like = like;
                obj.tags = tags;
                return obj;
            },
            creatPageBar: function (total, pageNum, prePage, nextPage, hasPreviousPage, hasNextPage, navigatepageNums, lastPage, pages) {
                var pageObj = new Object;
                pageObj.total = total;
                pageObj.pageNum = pageNum;
                pageObj.prePage = prePage;
                pageObj.nextPage = nextPage;
                pageObj.hasPreviousPage = hasPreviousPage;
                pageObj.hasNextPage = hasNextPage;
                pageObj.navigatepageNums = navigatepageNums;
                pageObj.lastPage = lastPage;
                pageObj.pages = pages;

                return pageObj;

            },
            getMsg: function (pn) {
                console.log("===================" + pn + "========================")
                var articels;
                $.ajax({
                    async: false,
                    url: "/getArticles/" + pn,
                    success: function (data) {
                        articels = data;
                    }
                })

                return articels;

            },
            update_articles: function (pn) {
                console.log(pn)
                this.objs.splice(0, this.objs.length);
                var articles = this.getMsg(pn);
                console.log(articles)
                this.renderData(articles)
            },
            renderData: function (articles) {
                this.objs.length = 0;
                this.page_bar.length = 0;
                var pagetotal = articles.extend.pageInfo;
                var pagesdata = pagetotal.list
                //渲染文章数据
                for (var i in pagesdata) {
                    console.log("+++++++++++++++++++++++++++++++++")
                    console.log(pagesdata[i])
                    console.log("+++++++++++++++++++++++++++++++++")
                    var obj = this.createObj(pagesdata[i].user.avatarUrl, pagesdata[i].articleTitle, pagesdata[i].articleContentText, pagesdata[i].viewCount, pagesdata[i].commentCount, pagesdata[i].likeCount, pagesdata[i].tags);
                    console.log("=========================")
                    console.log(obj)
                    console.log("=========================")
                    this.objs.push(obj)
                }
                //渲染分页条数据 total,pageNum,isFirstPage,isLastPage,hasPreviousPage,hasNextPage,navigatepageNums,lastPage

                var pageBar = this.creatPageBar(pagetotal.total, pagetotal.pageNum, pagetotal.prePage, pagetotal.nextPage, pagetotal.hasPreviousPage, pagetotal.hasNextPage, pagetotal.navigatepageNums, pagetotal.lastPage, pagetotal.pages);
                //console.log("=========================")
                //console.log(pageBar)
                //console.log("=========================")
                this.page_bar = pageBar;

            }
        },
        created: function () {
            var articles = this.getMsg(1);
            console.log(articles)
            this.renderData(articles)
            console.log(articles)

        }
    });

    var vue_right = new Vue({
            el:"#right_div",
            data:{},
            mothod:{}
        });
})