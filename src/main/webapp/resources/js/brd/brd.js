/**
 * 
 */
 
var brd = brd || {};
brd = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.';	
	let _, js,  brdvue, name, cid;
	let init = () => {
		_ = $.ctx();
		js = $.js();
		cid = $.cid();
		brdvue = js + '/vue/brd_vue.js';
	}
	
	let onCreate = () =>{
		init()
		$.getScript(brdvue).done(()=>{
			setContentView()
			$('<a>',{
					text : '글쓰기',
					href : '#',
					click : e =>{	
						e.preventDefault()
						write()
					}
				})
				.addClass('nav-link')
				.appendTo('#go_write')
		}).fail(()=>{alert(WHEN_ERR)})	
	}
	let setContentView =()=>{
			$('head').html(brd_vue.brd_head({css: $.css(), img: $.img(),  js: $.js()}))
			$('body').addClass('text-center')
			.html(brd_vue.brd_body({css: $.css(), img: $.img(),  js: $.js()}))  	
			$('#recentid .media').remove()//.media유튜브 건들떄 씀
			$('#recentid .d-block').remove()
			$('#recentid').append('<h1>등록된 글이 없습니다</h1>')
//			$('#recentid').text('등록된 글이 없습니다')
	}
	
	let write = () =>{
//		alert('>>> '+cid)	
		$('#recentid').html(brd_vue.brd_write(cid))
	}
	
	
	return {onCreate}
})();