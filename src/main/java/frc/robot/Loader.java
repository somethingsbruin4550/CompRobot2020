/**
 * String state = "init";
 * 
 * if(loading){
 *  state = "loading"
 * } else if(shooting){`    
 *  state = "shooting"
 * } else if(init){
 *  state = "init"
 * }
 * 
 * 
 * stateController(){
 *  if(state.equals("loading"))
 *      stateLoading()
 *  else if(state.equals("shooting"))
 *      stateShooting()
 *  else if(state.equals("init"))
 *      stateInit()
 * }
 * 
 * 
 * stateLoading(){
 *  findEmpty();
 * }
 * 
 * stateShooting(){
 *  findBall();
 * }
 * 
 * stateInit(){
 *  rotate();
 * }
 * 
 */