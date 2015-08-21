$(document).ready(function () {
    //左侧菜单导航栏的动态效果
    //显示当前课程的子菜单并隐藏其他课程的子菜单
    $("#sidebarWrapper li ul").hide();
    $("#sidebarWrapper li a.current").parent().find("ul").slideToggle("slow");
    //点击课程时，切换子菜单和样式
    $("#sidebarWrapper li a.nav-top-item").click(
			function () {
			    $(this).parent().siblings().find("ul").slideUp("normal"); //收起当前阶段菜单中的其他二级子菜单
			    $(this).parent().parent().siblings().find("ul").slideUp("normal"); //收起其他阶段菜单中的二级子菜单
			    $(this).next().slideToggle("normal"); //展开当前菜单的二级菜单
                //切换菜单的样式
			    $(this).parent().siblings().find("a").removeClass("current");
			    $(this).parent().parent().siblings().find("a").removeClass("current");
			    $(this).toggleClass("current");
                return false;
			}
		);

    //点击Day0x菜单时，切换样式
    $("#sidebarWrapper>ul>li>ul li a").click(
			function () {
			    $(this).parent().siblings().find("a").removeClass("current");
			    $(this).toggleClass("current");
			    return false;
			}
		);

    //鼠标悬浮菜单项时的动态效果
    $("#sidebarWrapper li .nav-top-item").hover(
			function () {
			    $(this).stop().animate({ paddingRight: "20px" }, 200);
			},
			function () {
			    $(this).stop().animate({ paddingRight: "8px" });
			}
		);

			//popup-box
/*
    //Minimize Content Box

    $(".content-box-header h3").css({ "cursor": "s-resize" }); // Give the h3 in Content Box Header a different cursor
    $(".closed-box .content-box-content").hide(); // Hide the content of the header if it has the class "closed"
    $(".closed-box .content-box-tabs").hide(); // Hide the tabs in the header if it has the class "closed"

    $(".content-box-header h3").click( // When the h3 is clicked...
			function () {
			    $(this).parent().next().toggle(); // Toggle the Content Box
			    $(this).parent().parent().toggleClass("closed-box"); // Toggle the class "closed-box" on the content box
			    $(this).parent().find(".content-box-tabs").toggle(); // Toggle the tabs
			}
		);

    // Content box tabs:

    $('.content-box .content-box-content div.tab-content').hide(); // Hide the content divs
    $('ul.content-box-tabs li a.default-tab').addClass('current'); // Add the class "current" to the default tab
    $('.content-box-content div.default-tab').show(); // Show the div with class "default-tab"

    $('.content-box ul.content-box-tabs li a').click( // When a tab is clicked...
			function () {
			    $(this).parent().siblings().find("a").removeClass('current'); // Remove "current" class from all tabs
			    $(this).addClass('current'); // Add class "current" to clicked tab
			    var currentTab = $(this).attr('href'); // Set variable "currentTab" to the value of href of clicked tab
			    $(currentTab).siblings().hide(); // Hide all content divs
			    $(currentTab).show(); // Show the content div with the id equal to the id of clicked tab
			    return false;
			}
		);

    //Close button:

    $(".close").click(
			function () {
			    $(this).parent().fadeTo(400, 0, function () { // Links with the class "close" will close parent
			        $(this).slideUp(400);
			    });
			    return false;
			}
		);

    // Alternating table rows:

    $('tbody tr:even').addClass("alt-row"); // Add class "alt-row" to even table rows

    // Check all checkboxes when the one in a table head is checked:

    $('.check-all').click(
			function () {
			    $(this).parent().parent().parent().parent().find("input[type='checkbox']").attr('checked', $(this).is(':checked'));
			}
		);

    // Initialise Facebox Modal window:

    $('a[rel*=modal]').facebox(); // Applies modal window to any link with attribute rel="modal"
*/
    // Initialise jQuery WYSIWYG:

	if ($(".wysiwyg").wysiwyg != undefined)
        $(".wysiwyg").wysiwyg(); // Applies WYSIWYG editor to any textarea with the class "wysiwyg"

});
  
  
  