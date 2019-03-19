   //------------------------个人资料----------------------------
    var btn = document.getElementById('showModel');
    var close = document.getElementsByClassName('close')[0];
    var cancel = document.getElementById('cancel');
    var modal = document.getElementById('modal');
    btn.addEventListener('click', function(){
        modal.style.display = "block";
    });
    close.addEventListener('click', function(){
        modal.style.display = "none";
    });
    cancel.addEventListener('click', function(){
        modal.style.display = "none";
    });
    
    //------------------------资料更新----------------------------
    var btn1 = document.getElementById('showModel1');
    var close1 = document.getElementsByClassName('close1')[0];
    var cancel1 = document.getElementById('cancel1');
    var modal1 = document.getElementById('modal1');
    btn1.addEventListener('click', function(){
        modal1.style.display = "block";
    });
    close1.addEventListener('click', function(){
        modal1.style.display = "none";
    });
    cancel1.addEventListener('click', function(){
        modal1.style.display = "none";
    });

    //-----------------------头像修改-----------------------------
    var btn2 = document.getElementById('showModel2');
    var close2 = document.getElementsByClassName('close2')[0];
    var cancel2 = document.getElementById('cancel2');
    var modal2 = document.getElementById('modal2');
    btn2.addEventListener('click', function(){
        modal2.style.display = "block";
    });
    close2.addEventListener('click', function(){
        modal2.style.display = "none";
    });
    cancel2.addEventListener('click', function(){
        modal2.style.display = "none";
    });