
public class HashTable {

	HashEntry []table;
	private static final int TableSize = 100;
	
	public HashTable(){
		this.table = new HashEntry[TableSize];
		
		for(int i=0;i<TableSize;i++){
			this.table[i] = null;
		}
	}
	
	
	public int get(int key){		
		int hashValue = hashFunction(key);
		
		if(table[hashValue] == null){
			return -1;
		}else{
			HashEntry entry = table[hashValue];
			while(entry!= null && entry.getKey() != key){
				entry = entry.getNext();
			}
			
			if(entry==null){
				return -1;
			}else{
				if(entry.getKey() == key){
					return entry.getValue();
				}else{
					return -1;
				}
			}
		}
	}
	
	public void put(int key,int value){
		int hashValue = hashFunction(key);
		
		if(table[hashValue] == null){
			table[hashValue] = new HashEntry(key,value);
		}else{
			HashEntry entry = table[hashValue];
			
			while(entry.getNext()!= null && entry.getKey() !=key ){
				entry = entry.getNext();
			}
			
			if(entry.getNext() == null){			
				 entry.setNext(new HashEntry(key,value));
			}else if(entry.getKey()==key){
				entry.setValue(value);
			}
		}
	}

	public void remove(int key){
		int hashValue = hashFunction(key);
		
		if(table[hashValue] == null){
			return;
		}else{
			HashEntry entry = table[hashValue];
			HashEntry prevEntry = null;
			
			while(entry.getNext() != null && entry.getKey() != key){
				prevEntry = entry;
				entry = entry.getNext();
			}
			
	
			if(entry.getKey() == key){
				if(prevEntry == null){
					table[hashValue] = entry.getNext();
				}else{
					prevEntry.setNext(entry.getNext());
				}
			}
		}
			
	}

	private int hashFunction(int key) {
		// TODO Auto-generated method stub
		//return key%TableSize;
		return key% 9;
		//return key%TableSize;
	}
}
