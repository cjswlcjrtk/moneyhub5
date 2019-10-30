"use strict";
var auth = auth || {};
auth = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.';	
	let _, js, vue;
	
	let init = () => {
		_ = $.ctx();
		js = $.js();
		vue = js + '/vue/auth_vue.js';	//스트링값, 객체가 아니다	
	}	
	
	let onCreate =()=>{
        init()
        $.getScript(vue).done(()=>{
        	setContentView()
    		$('#a_go_join').click(e=>{
         		e.preventDefault()
         		join()
    		})
        }).fail(()=>{alert(WHEN_ERR)})
    }
	
	
	let setContentView =()=>{
   	 login()
   }
	
	let join =()=>{
		init()
    	$('head').html(auth_vue.join_head())
        $('body').addClass('text-center')
        .html(auth_vue.join_body())
        $('<button>',{
            text : 'Continue to checkout',
            href : '#',
            click : e=>{
            	e.preventDefault();
            	let data = {cid : $('#clientid').val(), pwd : $('#password').val()}
            	alert('전송아이디: '+data.cid)
                $.ajax({
			    	url : _+'/client/join',
			    	type : 'POST',
			    	dataType : 'json',
			    	data : JSON.stringify(data),
			    	contentType : 'application/json',
			    	success : d => {
			    		alert('AJAX 성공 아이디: '+d.cid+', 성공비번: '+d.pwd)
			    		login()
			    	},
			    	error : e => {
			    		alert('AJAX 실패')
			    	}
            	})
                
            }
        })
        .addClass('btn btn-primary btn-lg btn-block')
        .appendTo('#btn_join')
    }
	
	let login =()=>{
		init()
    	let x = {css: $.css(), img: $.img(),  js: $.js()}
    	$('head').html(auth_vue.login_head(x))
        $('body').addClass('text-center')
        .html(auth_vue.login_body(x))
        $('<button>',{
        	type : "submit",
        	text : "Sign in",
        	click : e => {
        		e.preventDefault()
        		let client = {cid: $('#cid').val(), pwd: $('#pwd').val() }        		
        		$.ajax({
        			url : _+'/client/login', 
        			type : 'POST',
			    	dataType : 'json',
			    	data : JSON.stringify(client),
			    	contentType : 'application/json',
			    	success : d => {
			    		alert(d.cid+'님 환영합니다.')
			    		login()
			    	},
			    	error : e => {
			    		alert('AJAX 실패')
			    	}
        		})
        		
        	}
        })
        .addClass('btn btn-lg btn-primary btn-block')
    	.appendTo('#btn_login')	
    }
	
	
	
	
	return {onCreate, join, login}
	
})();