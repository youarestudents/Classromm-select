<template>
	<view class="content">
		<view class="admin" v-if="Ashow">

			<br />
			<text class="tit">登录</text>
			<br />
			<br />

			<view style="margin-top: 5%;">
				<text>学号：</text> <input type="text" name="" v-model="txt"><br />
				<br />
			</view>
			<view style="margin-top: 5%;">
				<text>密码：</text> <input type="password" v-model="psw" /><br />
			</view>



			<br />
			<button @click="Tadmin">登录</button> <br />
			<text class="zhuce" @click="Tozhuce">还没有账号，注册账号</text>

		</view>
		<view class="admin" v-if="!Ashow">
			<br />
			<text class="tit">注册</text>
			<br />
			<!--   输入账号和密码 -->
			<view style="margin-top: 5%;">
				<text>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</text> <input type="text" name=""
					v-model="txt"><br />
			</view>

			<br />
			<view style="margin-top: 5%;">
				<text>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</text> <input type="password" v-model="psw" />
			</view>

			<br />
			<view style="margin-top: 5%;">
				<text>确认密码：</text> <input type="password" v-model="psw2" />
			</view>
			<br />

           <text style="color: red;" v-if="x">两次密码不一至</text>
			<button @click="zhuce">登录</button>


		</view>
	</view>
</template>

<script>
	import {get} from '../../request/index.js'
	import {post} from '../../request/index.js'
	export default {
		data() {
			return {
				
				txt: '',
				psw: '',
				Ashow: true,
				students: [],//初始化值
				classids:[],
				overtimes:[],
				classrooms:[],
				nowtime:0,
                x:false,
				pws2:""
			}
		},
		onLoad() {
			get('http://localhost:8083/select/address/classroom') //像后端发请求 验证登录
				.then(data => {
					// console.log(data);
					this.students = data
					
				})
				.catch(error => {
					console.error(error);
				});


          get('http://localhost:8083/insert/use/findclassroom').then(data=>{
		    console.log(data)
			  for(var i=0;i<data.length;i++){
				  this.classids.push(data[i].classid)
				 
				  this.overtimes.push(data[i].overtime)
		
				
			  }
			  		
		  })
		
	 setTimeout(()=>{

		  this.nowtime=Date.now();
		 get('http://localhost:8083/yuyue/classroom').then(data=>{
		 	this.classrooms=data
			
		 		
		 for(var j=0;j<this.classids.length;j++){
		 	for(var i=0;i<this.classrooms.length;i++){
			
		 		if(this.classids[j]==this.classrooms[i].id && this.overtimes[j]<this.nowtime){
		 				
		 			post('http://localhost:8083/yuyue/updaclass',{
		 				usedemo:false,
		 				id:this.classids[j]
		 			}).then(data=>{
		 				console.log("成功发送")
		 			})
		 			
		 		}
		 	}
		 }
		 	})
		 
	 },500)
		},
	
		methods: {
			Tadmin() {
				for (var i = 0; i < this.students.length; i++) {
					if (this.students[i].sid == this.txt && this.students[i].password == this.psw) { //验证能否登录
                           uni.setStorage({  //把登录的信息存放到本地存储，方便登陆时查看
                           key:"id",
                           data:this.students[i].sid,
                           success: function (){
                           console.log("存储成功")
                           }
                           })
						wx.switchTab({
							url:'/pages/calss/index'
						})
						console.log("登陆成功")
						break
					}
				}

			},
			Tozhuce() {
				this.Ashow = false
			},
			zhuce(){
				if(this.psw!=this.psw2){
					this.x=true
				}
				
			}

		}
	}
</script>

<style scoped>
	.content {
		width: 100%;
		height: 800px;
		background: blanchedalmond;
	}

	.admin {
		text-align: center;
		width: 80%;
		height: 40%;
		background: white;
		position: relative;
		top: 15%;
		left: 10%;
	}

	.tit {

		font-size: 25px;
	}

	.admin input {
		display: inline-block;
		border: 1px solid black;
		width: 60%;

	}

	.admin text {
		margin-left: -8%;
	}

	.admin button {
		width: 60%;
		margin-left: 20%;
		background: wheat;
		margin-top: 5%;
	}

	.zhuce {
		color: blue;
	

	}
</style>