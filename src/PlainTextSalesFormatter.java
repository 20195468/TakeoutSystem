
public class PlainTextSalesFormatter implements SalesFormatter{

	static private PlainTextSalesFormatter plain=null;
	private final static String newline=System.getProperty("line.separator");//»»ÐÐ·û
	
	private PlainTextSalesFormatter() {
		
	}
	
	 public static PlainTextSalesFormatter getPlainTextSalesFormatter(){
	        if(plain==null){
	            plain=new PlainTextSalesFormatter();
	        }
	        return plain;
	    }
	
	@Override
	public String formatOrders(Orders orders) {
		StringBuffer sb=new StringBuffer();
			for(OrderItem items:orders) {
				sb.append(items.getAnimal().getcode());
				sb.append("    ");
				sb.append(items.getAnimal().getanimal());
				sb.append("    ");
				sb.append(items.getQuantity());
				sb.append(newline);
			}
		String out=sb.toString();
		return out;
	}

}
